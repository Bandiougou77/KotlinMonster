import dresseur.Entraineur
import item.*
import monstre.*


// Fonction utilitaire pour mettre de la couleur dans la console
fun changeCouleur(message: String, couleur: String = ""): String {
    val reset = "\u001B[0m"
    val codeCouleur = when (couleur.lowercase()) {
        "rouge" -> "\u001B[31m"
        "vert" -> "\u001B[32m"
        "jaune" -> "\u001B[33m"
        "bleu" -> "\u001B[34m"
        "magenta" -> "\u001B[35m"
        "cyan" -> "\u001B[36m"
        "blanc" -> "\u001B[37m"
        else -> "" // pas de couleur si non reconnu
    }
    return "$codeCouleur$message$reset"
}
// === Création d’espèces de monstres ===
val especeSpringleaf = EspeceMonstre (1,"Springleaf","Graine",9, 11, 10,12,13,60, 6.5,9.0,8.0,7.0,10.0, 34.0,"Petir monstre espiègle rond comme une graine, adore le soleil ", "Sa feuille sur ca tete indique son humeur","Curieux, amical, timide")
val especeFlamkip = EspeceMonstre(4,"flamkip","Animal", 12,8,13,16, 7,50,105.5,9.5, 9.5,9.5,6.5,22.0, "Petit animal entouré de flammes, déteste le froid.", "Sa flamme change d'intensité selon son énergie", "impulsif,joueur,loyal")
val especeAquamy = EspeceMonstre(1,nom="Aquamy",type="Meteo",10,11, 9,14,14,55,9.0,10.0, 7.5,12.0,12.0,27.0, "Créature vaporeuse semblable à un nuage, produit des gouttes pures.", "Fait baisser la température en s’endormant.", "Calme, rêveur, mystérieux")
// === Création d’un monstre et test d’items ===

val joueur = Entraineur(1,"Sacha",500)
val regis = Entraineur(2,"Regis", argent = 200)

val kube = MonsterKube(2, "Kube Basique", "Permet de capturer un monstre", 50)
fun main() {
    // === Test couleurs ===
    println(changeCouleur("Hello", "rouge"))
    println(changeCouleur("World", "bleu"))
    println("Hello ${changeCouleur("my", "jaune")} World")
    println(changeCouleur("Pokemon", "magenta"))

    // === Création de dresseurs ===
    val joueur = Entraineur(1, "Sacha", 100)
    val rival = Entraineur(2, "Regis", 200)

    println("Dresseur : ${joueur.nom} | Argent : ${joueur.argent}")
    println("Dresseur : ${rival.nom} | Argent : ${rival.argent}")

    joueur.argent += 50
    println("Après gain, argent de ${joueur.nom} : ${joueur.argent}")

    joueur.afficheDetail()
    rival.afficheDetail()



    println(especeAquamy.afficheArt())
    println(especeFlamkip.afficheArt())
    println(especeSpringleaf.afficheArt())

    joueur.sacItem.add(kube)


    // === Test Badge ===
    val badgeRoche = Badge(1, "Badge Roche", "Premier badge obtenu à Argenta", joueur)
    println("Nom du badge : ${badgeRoche.nom}")
    println("Champion associé : ${badgeRoche.champion.nom}")


}



