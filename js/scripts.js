
        // Envoyer les données au back-end Java
        document.getElementById('signupForm').addEventListener('submit', function(e) {
            e.preventDefault(); // Empêche le rechargement de la page

            const formData = {
                nom: document.getElementById('nom').value,
                email: document.getElementById('email').value,
                password: document.getElementById('password').value
            };

            fetch('http://localhost:8080/api/users', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(formData)
            })
            .then(response => response.json())
            .then(data => alert('Compte créé avec succès !'))
            .catch(error => alert('Erreur lors de la création du compte.'));
        });



        // Gestionnaire de candidatures
        const applications = {}; // Objet pour suivre l'état des candidatures

        // Gestion du clic sur le bouton "postulée"
        document.querySelectorAll('.toggle-application').forEach(button => {
            button.addEventListener('click', () => {
                const jobId = button.dataset.jobId;
                const jobCard = button.closest('.job-card');
                const jobTitle = jobCard.querySelector('h3').innerText;

                // Basculer entre "postulée" et "non postulée"
                if (!applications[jobId]) {
                    applications[jobId] = { jobTitle, status: 'postulée', date: new Date().toLocaleString() };
                    button.textContent = 'Marquer comme non postulée';
                } else {
                    delete applications[jobId];
                    button.textContent = 'Marquer comme postulée';
                }

                updateApplicationHistory();
            });
        });

        // Mettre à jour l'historique des candidatures
        function updateApplicationHistory() {
            const historyList = document.getElementById('application-history');
            historyList.innerHTML = '';

            Object.values(applications).forEach(application => {
                const listItem = document.createElement('li');
                listItem.textContent = `${application.jobTitle} - ${application.status} le ${application.date}`;
                historyList.appendChild(listItem);
            });
        }
