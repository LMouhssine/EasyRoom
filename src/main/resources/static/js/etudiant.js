document.addEventListener('DOMContentLoaded', function () {
    const btnCancel = document.getElementById('btnCancel');
    const btnSubmit = document.getElementById('btnSubmit');
    const etudiantForm = document.getElementById('etudiantForm');
    const etudiantTableBody = document.getElementById('etudiantTableBody');
    let etudiantId = null;

    // Charger les étudiants au démarrage
    loadEtudiants();

    // Charger les étudiants
    function loadEtudiants() {
        fetch('/api/etudiants')
            .then(response => response.json())
            .then(etudiants => {
                etudiantTableBody.innerHTML = '';
                etudiants.forEach(addEtudiantToTable);
            });
    }

    // Ajouter un étudiant au tableau
    function addEtudiantToTable(etudiant) {
        const row = document.createElement('tr');
        row.setAttribute('data-id', etudiant.id_etudiant);
        row.innerHTML = `
            <td>${etudiant.prenom_etudiant}</td>
            <td>${etudiant.nom_etudiant}</td>
            <td>${etudiant.email_etudiant}</td>
            <td>
                <button class="btn btn-warning btn-sm" onclick="editEtudiant(${etudiant.id_etudiant})">Modifier</button>
                <button class="btn btn-danger btn-sm" onclick="deleteEtudiant(${etudiant.id_etudiant})">Supprimer</button>
            </td>
        `;
        etudiantTableBody.appendChild(row);
    }

    // Modifier un étudiant
    window.editEtudiant = function(id) {
        fetch(`/api/etudiants/${id}`)
            .then(response => response.json())
            .then(etudiant => {
                etudiantId = etudiant.id_etudiant;
                etudiantForm.prenom.value = etudiant.prenom_etudiant;
                etudiantForm.nom.value = etudiant.nom_etudiant;
                etudiantForm.email.value = etudiant.email_etudiant;
                etudiantForm.motDePasse.value = etudiant.motDePasse_etudiant;
                btnCancel.style.display = 'inline-block';
                btnSubmit.textContent = 'Modifier';
            });
    };

    // Supprimer un étudiant
    window.deleteEtudiant = function(id) {
        if (confirm('Voulez-vous vraiment supprimer cet étudiant ?')) {
            fetch(`/api/etudiants/${id}`, { method: 'DELETE' })
                .then(() => loadEtudiants());
        }
    };

    // Soumettre le formulaire (ajout ou modification)
    etudiantForm.addEventListener('submit', function(e) {
        e.preventDefault();
        const formData = {
            prenom_etudiant: etudiantForm.prenom.value,
            nom_etudiant: etudiantForm.nom.value,
            email_etudiant: etudiantForm.email.value,
            motDePasse_etudiant: etudiantForm.motDePasse.value
        };

        const url = etudiantId ? `/api/etudiants/${etudiantId}` : '/api/etudiants';
        const method = etudiantId ? 'PUT' : 'POST';

        fetch(url, {
            method: method,
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(formData)
        })
        .then(response => response.json())
        .then(() => {
            loadEtudiants();
            etudiantForm.reset();
            etudiantId = null;
            btnCancel.style.display = 'none';
            btnSubmit.textContent = 'Ajouter';
        })
        .catch(error => console.error('Erreur:', error));
    });

    // Annuler la modification
    btnCancel.addEventListener('click', function() {
        etudiantForm.reset();
        etudiantId = null;
        btnCancel.style.display = 'none';
        btnSubmit.textContent = 'Ajouter';
    });
});