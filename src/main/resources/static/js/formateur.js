document.addEventListener('DOMContentLoaded', function () {
    // Cacher le bouton "Annuler" au début
    const btnCancel = document.getElementById('btnCancel');
    const btnSubmit = document.getElementById('btnSubmit');
    const formateurForm = document.getElementById('formateurForm');
    const formateurTableBody = document.getElementById('formateurTableBody');

    let formateurId = null;

    // Fonction pour ajouter un formateur à la table
    function addFormateurToTable(formateur) {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${formateur.prenom}</td>
            <td>${formateur.nom}</td>
            <td>${formateur.email}</td>
            <td>
                <button class="btn btn-warning btn-sm" onclick="editFormateur(${formateur.id})">Modifier</button>
                <button class="btn btn-danger btn-sm" onclick="deleteFormateur(${formateur.id})">Supprimer</button>
            </td>
        `;
        formateurTableBody.appendChild(row);
    }

    // Fonction pour modifier un formateur
    window.editFormateur = function (id) {
        // Ici, vous devez récupérer les données du formateur par son ID
        // et remplir le formulaire avec ses données
        formateurId = id;
        btnCancel.style.display = 'inline-block';  // Montrer le bouton annuler
        btnSubmit.textContent = 'Modifier'; // Changer le texte du bouton
        // Exemple d'ajout des valeurs dans le formulaire
        // formateurForm.prenom.value = formateur.prenom;
        // formateurForm.nom.value = formateur.nom;
        // formateurForm.email.value = formateur.email;
        // formateurForm.motDePasse.value = formateur.motDePasse;
    };

    // Fonction pour supprimer un formateur
    window.deleteFormateur = function (id) {
        if (confirm('Voulez-vous vraiment supprimer ce formateur ?')) {
            // Supprimer le formateur de la table
            const row = document.querySelector(`#formateurTableBody tr[data-id='${id}']`);
            row.remove();
        }
    };

    // Lors de la soumission du formulaire
    formateurForm.addEventListener('submit', function (e) {
        e.preventDefault();

        const formData = {
            prenom: formateurForm.prenom.value,
            nom: formateurForm.nom.value,
            email: formateurForm.email.value,
            motDePasse: formateurForm.motDePasse.value
        };

        if (formateurId) {
            // Modifier un formateur existant
            // Appeler une API ou une fonction pour mettre à jour un formateur par son ID
        } else {
            // Ajouter un nouveau formateur
            addFormateurToTable(formData);
        }

        formateurForm.reset();
        formateurId = null;
        btnCancel.style.display = 'none';
        btnSubmit.textContent = 'Ajouter';
    });

    // Action du bouton Annuler
    btnCancel.addEventListener('click', function () {
        formateurForm.reset();
        formateurId = null;
        btnCancel.style.display = 'none';
        btnSubmit.textContent = 'Ajouter';
    });
});
