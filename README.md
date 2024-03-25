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
├── data
│   ├── local
│   │   ├── dao                // Contient les interfaces DAO pour Room
│   │   │   └── RecipeDao.kt  // Interface DAO pour la gestion des recettes en local
│   │   └── database           // Contient la classe de base de données Room
│   │       └── RecipeDatabase.kt  // Classe de base de données Room pour les recettes
│   ├── model                 // Contient les modèles de données
│   │   └── Recipe.kt         // Modèle de données pour une recette
│   │   └── SeerchResponse.kt // Modèle de données pour la réponse de l'API
│   │   └── RecipeDetailResponse.kt // Modèle de données pour une catégorie de recette
│   └── remote
│       ├── api               // Contient les classes pour les appels réseau
│       │   └── RecipeApiService.kt  // Interface Retrofit pour les appels à l'API Food2Fork
│       └── repository        // Contient la classe Repository pour la gestion des données
│           └── RecipeRepository.kt  // Classe Repository pour la gestion des recettes
├── di                        // Contient les modules Dagger pour l'injection de dépendances
│   └── AppModule.kt          // Module Dagger pour la configuration de l'application
├── ui
│   ├── detail
│   │   ├── DetailActivity.kt // Activité pour afficher les détails d'une recette
│   │   └── DetailFragment.kt // Fragment pour afficher les détails d'une recette
│   ├── list
│   │   ├── ListActivity.kt   // Activité pour afficher la liste des recettes
│   │   └── ListFragment.kt   // Fragment pour afficher la liste des recettes
│   └── theme
│       └── Theme.kt          // Fichier pour définir le thème de l'application
└── util
└── NetworkUtil.kt        // Utilitaire pour la gestion de la connectivité réseau

</pre>
