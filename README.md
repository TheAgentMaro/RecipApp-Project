# FoodRecipesApp
FoodRecipesApp est une application Android permettant aux utilisateurs de rechercher et de découvrir une variété de recettes de cuisine. L'application offre une expérience utilisateur fluide et intuitive avec une interface utilisateur attrayante.

## Fonctionnalités principales :

- Affichage d'un écran de chargement avec le logo de l'application.
- Liste des recettes disponibles avec pagination.
- Affichage des détails d'une recette sélectionnée.
- Fonctionnalité de recherche permettant de filtrer les recettes par titre.
- Filtrage des recettes par catégorie.
- Gestion des erreurs réseau avec un message d'erreur approprié.
- Fonctionnement hors ligne avec utilisation d'une base de données locale pour la mise en cache des recettes.

## Technologies utilisées :

- Kotlin : Le langage de programmation principal utilisé pour le développement de l'application Android.
- Retrofit : Un client HTTP typé pour effectuer des requêtes réseau afin de récupérer des données de recette à partir d'une API distante.
- Glide : Une bibliothèque de chargement d'images pour charger et afficher les images de recette de manière efficace.
- ViewModel et LiveData : Composants d'architecture Android utilisés pour gérer les données liées à l'interface utilisateur de manière consciente du cycle de vie.
- RecyclerView : Une vue flexible pour présenter une liste déroulante d'éléments de recette.
- SearchView : Un widget Android utilisé pour fournir une fonctionnalité de recherche dans l'application.

## Installation

Pour exécuter le projet RecipApp sur votre machine locale, suivez ces étapes :

- Clonez le dépôt :

```bash
git clone https://github.com/TheAgentMaro/RecipApp-Project.git
```

- Ouvrez le projet dans Android Studio.

- Compilez et exécutez le projet sur un émulateur Android ou sur un appareil physique.

## Architecture :
<pre>

com.supinfo.recipapp
¦
+-- data
¦   +-- model
¦   ¦   +-- Recipe.kt                    // Modèle de données pour une recette
¦   ¦   +-- SearchResult.kt              // Modèle de données pour un résultat de recherche
¦   +-- network
¦   ¦   +-- ApiService.kt                // Interface définissant les appels réseau à l'API
¦   ¦   +-- RetrofitInstance.kt          // Singleton pour créer une instance Retrofit
¦   +-- repository
¦   ¦   +-- RecipeRepository.kt          // Logique métier pour l'accès aux données (API, cache, base de données)
¦   +-- local
¦       +-- database
¦       ¦   +-- RecipeDatabase.kt        // Classe abstraite pour la base de données Room
¦       ¦   +-- dao
¦       ¦       +-- RecipeDao.kt         // Interface DAO pour les opérations sur la table Recipe
¦       +-- cache
¦           +-- RecipeCache.kt           // Implémentation du cache pour stocker les données localement
¦
+-- ui
¦   +-- adapters
¦   ¦   +-- RecipeListAdapter.kt        // Adaptateur pour afficher une liste de recettes dans un RecyclerView
¦   +-- screens
¦   ¦   +-- loading
¦   ¦   ¦   +-- LoadingActivity.kt      // Activité pour afficher un écran de chargement
¦   ¦   +-- recipeList
¦   ¦   ¦   +-- RecipeListActivity.kt   // Activité principale pour afficher la liste des recettes
¦   ¦   ¦   +-- RecipeListFragment.kt   // Fragment pour afficher la liste des recettes dans RecipeListActivity
¦   ¦   +-- recipeDetails
¦   ¦       +-- RecipeDetailsActivity.kt  // Activité pour afficher les détails d'une recette
¦   ¦       +-- RecipeDetailsFragment.kt  // Fragment pour afficher les détails d'une recette dans RecipeDetailsActivity
¦   +-- viewmodels
¦   ¦   +-- RecipeListViewModel.kt      // ViewModel pour gérer les données de la liste des recettes
¦   ¦   +-- RecipeDetailsViewModel.kt   // ViewModel pour gérer les données des détails d'une recette
¦   +-- fragments
¦       +-- SearchFragment.kt           // Fragment pour afficher l'interface de recherche
¦
+-- util
¦   +-- NetworkUtils.kt                 // Utilitaires pour gérer les opérations réseau
¦   +-- Constants.kt                    // Constantes utilisées dans l'application
¦
+-- MainActivity.kt                    // Activité principale de l'application
+-- SplashScreen.kt                    // Activité de l'écran de démarrage de l'application

</pre>


## Utilisation

- Lors du lancement de l'application, les utilisateurs se voient présenter une liste de recettes en fonction de la requête de recherche initiale (par exemple, "pizza").
- Les utilisateurs peuvent parcourir les recettes en sélectionnant différentes catégories à partir des boutons de catégorie (Dessert, Viande, Poulet, Végétarien).
- Pour rechercher des recettes spécifiques, les utilisateurs peuvent saisir des mots-clés ou des ingrédients dans la barre de recherche et appuyer sur Entrée.
- En cliquant sur un élément de recette dans la liste, une vue détaillée de la recette s'ouvre, affichant son titre, ses ingrédients et ses instructions de cuisson.
