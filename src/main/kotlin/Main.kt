package org.example

import dresseur.Entraineur
import item.*
import monstre.*
import org.example.Combat.Combat
import org.example.monstre.Capacite

val combat: Any
private val Entraineur.equipe: Any

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

    // === Création d’espèces de monstres ===
    val especeAquamy = EspeceMonstre("Aquamy", 55)
    val especeFlamkip = EspeceMonstre("Flamkip", 50)
    val especeSpringleaf = EspeceMonstre("Springleaf", 60)

    println(especeAquamy.afficheArt())
    println(especeFlamkip.afficheArt())
    println(especeSpringleaf.afficheArt())

    // === Création d’un monstre et test d’items ===
    val pikachu = EspeceMonstre("Pikachu", 35)
    val monstre = IndividuMonstre(pikachu, 20)

    val potion = Potion(1, "Potion", "Restaure 20 PV", 20)
    val kube = MonsterKube(2, "Kube Basique", "Permet de capturer un monstre", 0.5)

    joueur.ajouterItem(potion)
    joueur.ajouterItem(kube)

    joueur.utiliserItem(potion, monstre)
    joueur.utiliserItem(kube, monstre)

    // === Test ItemAntiStatut ===
    monstre.statut = "Poison"
    val antiPoison = ItemAntiStatut(3, "Anti-Poison", "Soigne l’empoisonnement", "Poison")
    antiPoison.utiliser(monstre)

    // === Test CT ===
    val ctTonnerre = CT(4, "CT-Tonnerre", "Apprend l’attaque Tonnerre", "Tonnerre")
    ctTonnerre.utiliser(monstre)
    ctTonnerre.utiliser(monstre) // deuxième fois → déjà appris

    // === Test Badge ===
    val badgeRoche = Badge(1, "Badge Roche", "Premier badge obtenu à Argenta", joueur)
    println("Nom du badge : ${badgeRoche.nom}")
    println("Champion associé : ${badgeRoche.champion.nom}")
}
import dresseur.Entraineur
import monstre.*
import combat.Combat

fun main() {
    val sacha = Entraineur("Sacha")
    val regis = Entraineur("Regis")

    val pikachu = IndividuMonstre(EspeceMonstre("Pikachu", 35), 35)
    val salameche = IndividuMonstre(EspeceMonstre("Salameche", 39), 39)

    sacha.equipe.add(pikachu)
    regis.equipe.add(salameche)

    val combat = Combat(sacha, regis)
    combat.lancer()
}

fun main() {
    val sacha = Entraineur("Sacha")
    val regis = Entraineur("Regis")

    val pikachu = IndividuMonstre(EspeceMonstre("Pikachu", 35), 35)
    val salameche = IndividuMonstre(EspeceMonstre("Salameche", 39), 39)

    // Ajouter des capacités
    val eclair = Capacite("Éclair", 10, 95)
    val charge = Capacite("Charge", 8, 100)
    val flammes = Capacite("Flammes", 12, 90)

    pikachu.capacites.add(eclair)
    pikachu.capacites.add(charge)
    salameche.capacites.add(flammes)

    sacha.equipe.add(pikachu)
    regis.equipe.add(salameche)

    class IndividuMonstre(
        val espece: EspeceMonstre,
        var vie: Int
    ) {
        val nom: String = espece.nom
        val capacites: MutableList<Capacite> = mutableListOf()  // <- obligatoire
    }


    // Exemple d’utilisation
    pikachu.utiliserCapacite(eclair, salameche)
    salameche.utiliserCapacite(flammes, pikachu)
}
