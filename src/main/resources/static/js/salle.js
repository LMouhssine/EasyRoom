// Charger les salles au chargement de la page
document.addEventListener('DOMContentLoaded', loadSalles);

// Gérer la soumission du formulaire
document.getElementById('salleForm').addEventListener('submit', function(e) {
    e.preventDefault();
    saveSalle();
});

// Charger toutes les salles
function loadSalles() {
    fetch('/api/salles')
        .then(response => response.json())
        .then(salles => {
            const tableBody = document.getElementById('salleTableBody');
            tableBody.innerHTML = '';
            
            salles.forEach(salle => {
                const row = createSalleRow(salle);
                tableBody.appendChild(row);
            });
        })
        .catch(error => console.error('Erreur:', error));
}

// Créer une ligne de tableau pour une salle
function createSalleRow(salle) {
    const row = document.createElement('tr');
    row.innerHTML = `
        <td>${salle.numero}</td>
        <td>${salle.nom}</td>
        <td>${salle.nombrePlaces}</td>
        <td>${salle.type}</td>
        <td>
            <button onclick="editSalle(${salle.id})" class="btn btn-sm btn-warning">Modifier</button>
            <button onclick="deleteSalle(${salle.id})" class="btn btn-sm btn-danger">Supprimer</button>
        </td>
    `;
    return row;
}

// Sauvegarder ou mettre à jour une salle
function saveSalle() {
    const salleId = document.getElementById('salleId').value;
    const salle = {
        numero: document.getElementById('numero').value,
        nom: document.getElementById('nom').value,
        nombrePlaces: parseInt(document.getElementById('nombrePlaces').value),
        type: document.getElementById('type').value
    };

    const url = salleId ? `/api/salles/${salleId}` : '/api/salles';
    const method = salleId ? 'PUT' : 'POST';

    fetch(url, {
        method: method,
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(salle)
    })
    .then(response => response.json())
    .then(() => {
        resetForm();
        loadSalles();
    })
    .catch(error => console.error('Erreur:', error));
}

// Éditer une salle
function editSalle(id) {
    fetch(`/api/salles/${id}`)
        .then(response => response.json())
        .then(salle => {
            document.getElementById('salleId').value = salle.id;
            document.getElementById('numero').value = salle.numero;
            document.getElementById('nom').value = salle.nom;
            document.getElementById('nombrePlaces').value = salle.nombrePlaces;
            document.getElementById('type').value = salle.type;
        })
        .catch(error => console.error('Erreur:', error));
}

// Supprimer une salle
function deleteSalle(id) {
    if (confirm('Êtes-vous sûr de vouloir supprimer cette salle ?')) {
        fetch(`/api/salles/${id}`, {
            method: 'DELETE'
        })
        .then(() => loadSalles())
        .catch(error => console.error('Erreur:', error));
    }
}

// Réinitialiser le formulaire
function resetForm() {
    document.getElementById('salleForm').reset();
    document.getElementById('salleId').value = '';
}