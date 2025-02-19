// Flouter les autres offres après un clic
document.querySelectorAll('.job-card').forEach(card => {
    card.addEventListener('click', () => {
        const container = document.getElementById('jobContainer');
        container.classList.add('blurred');
        card.classList.add('active');
    });
});

// Fonction pour rechercher des mots-clés
function searchJobs() {
    const input = document.getElementById('searchInput').value.toLowerCase();
    const cards = document.querySelectorAll('.job-card');

    cards.forEach(card => {
        const title = card.querySelector('.job-title').textContent.toLowerCase();
        const company = card.querySelector('.company-name').textContent.toLowerCase();

        if (title.includes(input) || company.includes(input)) {
            card.style.display = 'block';
        } else {
            card.style.display = 'none';
        }
    });
}

// Afficher le menu déroulant
document.querySelector('.menu-container button').addEventListener('click', () => {
    const dropdown = document.querySelector('.menu-container .dropdown-menu');
    dropdown.style.display = dropdown.style.display === 'block' ? 'none' : 'block';
});


document.querySelector('.menu-button').addEventListener('click', function (event) {
    const dropdown = document.querySelector('.dropdown-menu');
    dropdown.style.display = dropdown.style.display === 'block' ? 'none' : 'block';

    // Empêche de fermer si on clique sur le bouton
    event.stopPropagation();
    });

    // Fermer la liste déroulante si on clique ailleurs
    document.addEventListener('click', function () {
    const dropdown = document.querySelector('.dropdown-menu');
    dropdown.style.display = 'none';
    });

    async function openJavaWindow1() {
        try {
            const response = await fetch('http://localhost:8080/open-window', {
                method: 'POST'
            });

            if (response.ok) {
                alert("Fenêtre Java ouverte !");
            } else {
                alert("Erreur lors de l'ouverture de la fenêtre Java.");
            }
        } catch (error) {
            console.error("Erreur :", error);
            alert("Impossible de contacter le serveur.");
        }
    }

    async function openJavaWindow() {
        try {
            const response = await fetch('http://localhost:8080/open-window', {
                method: 'POST'
            });

            if (response.ok) {
                alert("Fenêtre Java ouverte !");
            } else {
                alert("Erreur lors de l'ouverture de la fenêtre Java.");
            }
        } catch (error) {
            console.error("Erreur :", error);
            alert("Impossible de contacter le serveur.");
        }
    }