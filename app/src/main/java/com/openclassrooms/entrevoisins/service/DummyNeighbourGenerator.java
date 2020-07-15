package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyNeighbourGenerator {

    public static List<Neighbour> DUMMY_NEIGHBOURS = Arrays.asList(
            new Neighbour(1, "Caroline", "https://i.pravatar.cc/150?u=a042581f4e29026704d", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",  "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot..",false),
            new Neighbour(2, "Jack", "https://i.pravatar.cc/150?u=a042581f4e29026704e", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",  "Salut ! Je suis un grand passioné de deux roues. Plus particulièrement quand il sagit de parcour en forêt. Si tu es un passioné comme moi, n'hesite pas.",false),
            new Neighbour(3, "Chloé", "https://i.pravatar.cc/150?u=a042581f4e29026704f", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",  "Bonjour, J'ai une passion pour le stylisme depuis que je suis petite. si vous le souhaitez je peut personnaliser vos vetements. N'hesitez pas a me donner vos avis. ",false),
            new Neighbour(4, "Vincent", "https://i.pravatar.cc/150?u=a042581f4e29026704a", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",  "Bonjour, Je suis un photographe. Je m'interesse a toutes les types de photos, Je peut travailler sur un paysage, un model ou autre. Donc si vous cherchez de belle photos pour un evenement, appelez moi.",false),
            new Neighbour(5, "Elodie", "https://i.pravatar.cc/150?u=a042581f4e29026704b", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",  "Bonjour a tous, Je suis coiffeuse depuis de nombreuses années. je travaille la plupart du temps a domicile. Donc si vous souhaitez une coiffeuse pour vous ou vos enfants, demandez moi.",false),
            new Neighbour(6, "Sylvain", "https://i.pravatar.cc/150?u=a042581f4e29026704c", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",  "Bonjour tous le monde, Je suis un tres grand fan de course a pied et de velo. Je chercherais un ou plusieurs fan comme moi prêt a m'accompagner. ",false),
            new Neighbour(7, "Laetitia", "https://i.pravatar.cc/150?u=a042581f4e29026703d", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",  "Hello ! Je vien d'emménager la semaine dernière, c'est beaucoup de changement pour moi alors je cherche simplement a fair de nouvelles rencontres. N'hésitez pas !",false),
            new Neighbour(8, "Dan", "https://i.pravatar.cc/150?u=a042581f4e29026703b", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",  "Salut! Je suis un grand fan de tenis et padel. Je cherche d'autre fan comme moi pour jouer quelques matchs que ce soit ensemble ou contre. Je suis egalement ouvert a decouvrir d'autre sports.",false),
            new Neighbour(9, "Joseph", "https://i.pravatar.cc/150?u=a042581f4e29026704d", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",  "Coucou tout le monde ! Je suis une grande fan de jeux de sociétés et de jeux de cartes. Si vous souhaitez passer des après midi calme autour d'un bon jeux de carte, appellez moi.",false),
            new Neighbour(10, "Emma", "https://i.pravatar.cc/150?u=a042581f4e29026706d", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",  "Salut a tous, je suis une grande sportive et je cherche des voisins pret a m'accompagner. J'adore decouvrir de nouveaux sports alors si vous souhaiter partager cette passion, prevenez moi!",false),
            new Neighbour(11, "Patrick", "https://i.pravatar.cc/150?u=a042581f4e29026702d", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",  "Salut a tous! je suis un musicien, je fais de la guitare depuis plus de 5 ans. je cherche d'autre fans pour monter un petit groupe ou juste s'amuser un peu. ",false),
            new Neighbour(12, "Ludovic", "https://i.pravatar.cc/150?u=a042581f3e39026702d", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",  "Bonjour! Je cherche des personnes prête a m'accompagner pour des longues balades en velo. j'ai une petite preference pour les balades en forêt, mais je peut aussi apprecier la route. ",false)
    );

    static List<Neighbour> generateNeighbours() {
        return new ArrayList<>(DUMMY_NEIGHBOURS);
    }
}
