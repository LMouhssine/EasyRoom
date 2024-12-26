document.addEventListener('DOMContentLoaded', function () {
    const btnCancel = document.getElementById('btnCancel');
    const btnSubmit = document.getElementById('btnSubmit');
    const formateurForm = document.getElementById('formateurForm');
    const formateurTableBody = document.getElementById('formateurTableBody');
    let formateurId = null;

    // Charger les formateurs au démarrage
    loadFormateurs();

    function loadFormateurs() {
        fetch('/api/formateurs')
            .then(response => response.json())
            .then(formateurs => {
                formateurTableBody.innerHTML = '';
                formateurs.forEach(addFormateurToTable);
            });
    }

    function addFormateurToTable(formateur) {
        const row = document.createElement('tr');
        row.setAttribute('data-id', formateur.idFormateur);
        row.innerHTML = `
            <td>${formateur.prenomFormateur}</td>
            <td>${formateur.nomFormateur}</td>
            <td>${formateur.emailFormateur}</td>
            <td>
                <button class="btn btn-warning btn-sm" onclick="editFormateur(${formateur.idFormateur})">Modifier</button>
                <button class="btn btn-danger btn-sm" onclick="deleteFormateur(${formateur.idFormateur})">Supprimer</button>
            </td>
        `;
        formateurTableBody.appendChild(row);
    }

    window.editFormateur = function(id) {
        fetch(`/api/formateurs/${id}`)
            .then(response => response.json())
            .then(formateur => {
                formateurId = formateur.idFormateur;
                formateurForm.prenom.value = formateur.prenomFormateur;
                formateurForm.nom.value = formateur.nomFormateur;
                formateurForm.email.value = formateur.emailFormateur;
                btnCancel.style.display = 'inline-block';
                btnSubmit.textContent = 'Modifier';
            });
    };

    window.deleteFormateur = function(id) {
        if (confirm('Voulez-vous vraiment supprimer ce formateur ?')) {
            fetch(`/api/formateurs/${id}`, { method: 'DELETE' })
                .then(() => loadFormateurs());
        }
    };

    formateurForm.addEventListener('submit', function(e) {
        e.preventDefault();
        const formData = {
            prenomFormateur: formateurForm.prenom.value,
            nomFormateur: formateurForm.nom.value,
            emailFormateur: formateurForm.email.value,
            motDePasseFormateur: formateurForm.motDePasse.value
        };

        const url = formateurId ? `/api/formateurs/${formateurId}` : '/api/formateurs';
        const method = formateurId ? 'PUT' : 'POST';

        fetch(url, {
            method: method,
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(formData)
        })
        .then(() => {
            loadFormateurs();
            formateurForm.reset();
            formateurId = null;
            btnCancel.style.display = 'none';
            btnSubmit.textContent = 'Ajouter';
        });
    });

    btnCancel.addEventListener('click', function() {
        formateurForm.reset();
        formateurId = null;
        btnCancel.style.display = 'none';
        btnSubmit.textContent = 'Ajouter';
    });
});