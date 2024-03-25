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

- Kotlin
- Android Jetpack (ViewModel, LiveData, Room)
- Retrofit pour les appels réseau
- RecyclerView pour l'affichage de la liste des recettes
- Picasso/Glide pour le chargement et l'affichage des images
- Git pour la gestion de version
- GitHub Actions pour l'intégration continue (en option)

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
