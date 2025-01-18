document.addEventListener('DOMContentLoaded', function () {
    const btnCancel = document.getElementById('btnCancel');
    const btnSubmit = document.getElementById('btnSubmit');
    const formationForm = document.getElementById('formationForm');
    const formationTableBody = document.getElementById('formationTableBody');
    const formateurSelect = document.getElementById('formateur');
    let formationId = null;

    // Charger les formateurs et les formations au démarrage
    loadFormateurs();
    loadFormations();

    // Charger les formateurs
    function loadFormateurs() {
        fetch('/api/formateurs')
            .then(response => response.json())
            .then(formateurs => {
                formateurSelect.innerHTML = '';
                formateurs.forEach(formateur => {
                    const option = document.createElement('option');
                    option.value = formateur.idFormateur;
                    option.textContent = `${formateur.prenomFormateur} ${formateur.nomFormateur}`;
                    formateurSelect.appendChild(option);
                });
            });
    }

    // Charger les formations
    function loadFormations() {
        fetch('/api/formations')
            .then(response => response.json())
            .then(formations => {
                formationTableBody.innerHTML = '';
                formations.forEach(addFormationToTable);
            });
    }

    // Ajouter une formation au tableau
    function addFormationToTable(formation) {
        const row = document.createElement('tr');
        row.setAttribute('data-id', formation.id_formation);
        row.innerHTML = `
            <td>${formation.nom_formation}</td>
            <td>${formation.formateur ? formation.formateur.prenomFormateur + ' ' + formation.formateur.nomFormateur : 'N/A'}</td>
            <td>${new Date(formation.dateDebut_formation).toLocaleDateString()}</td>
            <td>${new Date(formation.dateFin_formation).toLocaleDateString()}</td>
            <td>
                <button class="btn btn-warning btn-sm" onclick="editFormation(${formation.id_formation})">Modifier</button>
                <button class="btn btn-danger btn-sm" onclick="deleteFormation(${formation.id_formation})">Supprimer</button>
            </td>
        `;
        formationTableBody.appendChild(row);
    }

    // Modifier une formation
    window.editFormation = function(id) {
        fetch(`/api/formations/${id}`)
            .then(response => response.json())
            .then(formation => {
                formationId = formation.id_formation;
                formationForm.nomFormation.value = formation.nom_formation;
                formationForm.dateDebut.value = formation.dateDebut_formation.split('T')[0];  // Format YYYY-MM-DD
                formationForm.dateFin.value = formation.dateFin_formation.split('T')[0];      // Format YYYY-MM-DD
                formationForm.formateur.value = formation.formateur ? formation.formateur.idFormateur : '';
                btnCancel.style.display = 'inline-block';
                btnSubmit.textContent = 'Modifier';
            });
    };

    // Supprimer une formation
    window.deleteFormation = function(id) {
        if (confirm('Voulez-vous vraiment supprimer cette formation ?')) {
            fetch(`/api/formations/${id}`, { method: 'DELETE' })
                .then(() => loadFormations());
        }
    };

    // Soumettre le formulaire (ajout ou modification)
    formationForm.addEventListener('submit', function(e) {
        e.preventDefault();
        const formData = {
            nom_formation: formationForm.nomFormation.value,
            dateDebut_formation: formationForm.dateDebut.value,
            dateFin_formation: formationForm.dateFin.value,
            id_formateur: formationForm.formateur.value
        };

        const url = formationId ? `/api/formations/${formationId}` : '/api/formations';
        const method = formationId ? 'PUT' : 'POST';

        fetch(url, {
            method: method,
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(formData)
        })
        .then(response => response.json())
        .then(() => {
            loadFormations();
            formationForm.reset();
            formationId = null;
            btnCancel.style.display = 'none';
            btnSubmit.textContent = 'Ajouter';
        })
        .catch(error => console.error('Erreur:', error));
    });

    // Annuler la modification
    btnCancel.addEventListener('click', function() {
        formationForm.reset();
        formationId = null;
        btnCancel.style.display = 'none';
        btnSubmit.textContent = 'Ajouter';
    });
});