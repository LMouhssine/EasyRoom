document.addEventListener('DOMContentLoaded', function() {
    const btnCancel = document.getElementById('btnCancel');
    const btnSubmit = document.getElementById('btnSubmit');
    const adminForm = document.getElementById('adminForm');
    const adminTableBody = document.getElementById('adminTableBody');
    let adminId = null;

    loadAdmins();

    function loadAdmins() {
        fetch('/api/admins')
            .then(response => response.json())
            .then(admins => {
                adminTableBody.innerHTML = '';
                admins.forEach(addAdminToTable);
            });
    }

    function addAdminToTable(admin) {
        const row = document.createElement('tr');
        row.setAttribute('data-id', admin.idAdmin);
        row.innerHTML = `
            <td>${admin.prenomAdmin}</td>
            <td>${admin.nomAdmin}</td>
            <td>${admin.emailAdmin}</td>
            <td>${admin.permissionAdmin}</td>
            <td>
                <button class="btn btn-warning btn-sm" onclick="editAdmin(${admin.idAdmin})">Modifier</button>
                <button class="btn btn-danger btn-sm" onclick="deleteAdmin(${admin.idAdmin})">Supprimer</button>
            </td>
        `;
        adminTableBody.appendChild(row);
    }

    window.editAdmin = function(id) {
        fetch(`/api/admins/${id}`)
            .then(response => response.json())
            .then(admin => {
                adminId = admin.idAdmin;
                adminForm.prenom.value = admin.prenomAdmin;
                adminForm.nom.value = admin.nomAdmin;
                adminForm.email.value = admin.emailAdmin;
                adminForm.permission.value = admin.permissionAdmin;
                btnCancel.style.display = 'inline-block';
                btnSubmit.textContent = 'Modifier';
            });
    };

    window.deleteAdmin = function(id) {
        if (confirm('Voulez-vous vraiment supprimer cet administrateur ?')) {
            fetch(`/api/admins/${id}`, { method: 'DELETE' })
                .then(() => loadAdmins());
        }
    };

    adminForm.addEventListener('submit', function(e) {
        e.preventDefault();
        const formData = {
            prenomAdmin: adminForm.prenom.value,
            nomAdmin: adminForm.nom.value,
            emailAdmin: adminForm.email.value,
            motDePasseAdmin: adminForm.motDePasse.value,
            permissionAdmin: adminForm.permission.value
        };

        const url = adminId ? `/api/admins/${adminId}` : '/api/admins';
        const method = adminId ? 'PUT' : 'POST';

        fetch(url, {
            method: method,
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(formData)
        })
        .then(() => {
            loadAdmins();
            adminForm.reset();
            adminId = null;
            btnCancel.style.display = 'none';
            btnSubmit.textContent = 'Ajouter';
        });
    });

    btnCancel.addEventListener('click', function() {
        adminForm.reset();
        adminId = null;
        btnCancel.style.display = 'none';
        btnSubmit.textContent = 'Ajouter';
    });
});