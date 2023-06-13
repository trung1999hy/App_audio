package com.example.funnypranksounds.utils;

import com.example.funnypranksounds.R;

public class SoundUtil {

    public static int[] getList(String effectName) {
        int[] finalList = new int[]{};
        switch (effectName) {
            case "Air Horn":
                finalList = airHornList();
                break;

            case "Fart":
                finalList = fartList();
                break;

            case "Hair Clipper":
                finalList = hClipperList();
                break;

            case "Halloween":
                finalList = halloweenList();
                break;

            case "Burp":
                finalList = burpList();
                break;

            case "Breaking":
                finalList = breakingList();
                break;

            case "Stun Gun":
                finalList = stunGunList();
                break;

            case "Car Horn":
                finalList = carHornList();
                break;

            case "Engine Sound":
                finalList = engineList();
                break;

            case "Police Siren":
                finalList = sirenList();
                break;

            case "Door Bell":
                finalList = doorBellList();
                break;

            case "Man Sneeze":
                finalList = manSneezeList();
                break;

            case "Toilet Flush":
                finalList = flushList();
                break;

            case "Scary":
                finalList = scaryList();
                break;

            case "Man Cough":
                finalList = manCoughList();
                break;

            case "Gun":
                finalList = gunList();
                break;

            case "Laugh & Clap":
                finalList = laughList();
                break;

            case "Scissors":
                finalList = scissorsList();
                break;

            case "Woman Cough":
                finalList = womanCoughList();
                break;

            case "Woman Sneeze":
                finalList = womanSneezeList();
                break;
        }
        return finalList;
    }

    public static int[] airHornList() {
        return new int[]{
                R.raw.funny_airhorn_1,
                R.raw.funny_airhorn_2,
                R.raw.funny_airhorn_3,
                R.raw.funny_airhorn_4,
                R.raw.funny_airhorn_5,
                R.raw.funny_airhorn_6,
                R.raw.funny_airhorn_7,
                R.raw.funny_airhorn_8,
                R.raw.funny_airhorn_9
        };
    }

    public static int[] fartList() {
        return new int[]{
                R.raw.fart_fart_1,
                R.raw.fart_fart_2,
                R.raw.fart_fart_3,
                R.raw.fart_fart_4,
                R.raw.fart_fart_5,
                R.raw.fart_fart_6,
                R.raw.fart_fart_7,
                R.raw.fart_fart_8,
                R.raw.fart_fart_9,
                R.raw.fart_fart_10,
                R.raw.fart_fart_11,
                R.raw.fart_fart_12,
                R.raw.fart_fart_13,
                R.raw.fart_fart_14,
                R.raw.fart_fart_15
        };
    }

    public static int[] hClipperList() {
        return new int[]{
                R.raw.hair_clipper_1,
                R.raw.hair_clipper_2,
                R.raw.hair_clipper_3,
                R.raw.hair_clipper_4,
                R.raw.hair_clipper_5,
                R.raw.hair_clipper_6,
                R.raw.hair_clipper_7
        };
    }

    public static int[] halloweenList() {
        return new int[]{
                R.raw.halloween1,
                R.raw.halloween2,
                R.raw.halloween3,
                R.raw.halloween4,
                R.raw.halloween5,
                R.raw.halloween6,
                R.raw.halloween7,
                R.raw.halloween8,
                R.raw.halloween9,
                R.raw.halloween10,
                R.raw.halloween11,
                R.raw.halloween12,
                R.raw.halloween13,
                R.raw.halloween14,
                R.raw.halloween15,
                R.raw.halloween16,
                R.raw.halloween17,
                R.raw.halloween18,
                R.raw.halloween19,
                R.raw.halloween20
        };
    }

    public static int[] burpList() {
        return new int[]{
                R.raw.funny_burp_1,
                R.raw.funny_burp_2,
                R.raw.funny_burp_3,
                R.raw.funny_burp_4,
                R.raw.funny_burp_5,
                R.raw.funny_burp_6,
                R.raw.funny_burp_7,
                R.raw.funny_burp_8,
                R.raw.funny_burp_9,
                R.raw.funny_burp_10,
                R.raw.funny_burp_11,
                R.raw.funny_burp_12
        };
    }

    public static int[] breakingList() {
        return new int[]{
                R.raw.breaking_1,
                R.raw.breaking_2,
                R.raw.breaking_3,
                R.raw.breaking_4,
                R.raw.breaking_5,
                R.raw.breaking_6,
                R.raw.breaking_7,
                R.raw.breaking_8,
                R.raw.breaking_9,
                R.raw.breaking_10
        };
    }

    public static int[] stunGunList() {
        return new int[]{
                R.raw.stun_gun_1,
                R.raw.stun_gun_2,
                R.raw.stun_gun_3,
                R.raw.stun_gun_4,
                R.raw.stun_gun_5,
                R.raw.stun_gun_6,
                R.raw.stun_gun_7,
                R.raw.stun_gun_8,
                R.raw.stun_gun_9,
                R.raw.stun_gun_10
        };
    }

    public static int[] carHornList() {
        return new int[]{
                R.raw.funny_carhorn_1,
                R.raw.funny_carhorn_2,
                R.raw.funny_carhorn_3,
                R.raw.funny_carhorn_4,
                R.raw.funny_carhorn_5
        };
    }

    public static int[] engineList() {
        return new int[]{
                R.raw.funny_carengine_1,
                R.raw.funny_carengine_2,
                R.raw.funny_carengine_3,
                R.raw.funny_carengine_4,
                R.raw.funny_carengine_5
        };
    }

    public static int[] sirenList() {
        return new int[]{
                R.raw.funny_police_1,
                R.raw.funny_police_2,
                R.raw.funny_police_3,
                R.raw.funny_police_4,
                R.raw.funny_police_5,
                R.raw.funny_police_6
        };
    }

    public static int[] doorBellList() {
        return new int[]{
                R.raw.funny_doorbell_1,
                R.raw.funny_doorbell_2,
                R.raw.funny_doorbell_3,
                R.raw.funny_doorbell_4,
                R.raw.funny_doorbell_5,
                R.raw.funny_doorbell_6,
                R.raw.funny_doorbell_7,
                R.raw.funny_doorbell_8,
                R.raw.funny_doorbell_9,
                R.raw.funny_doorbell_10
        };
    }

    public static int[] manSneezeList() {
        return new int[]{
                R.raw.man_sneeze_1,
                R.raw.man_sneeze_2,
                R.raw.man_sneeze_3,
                R.raw.man_sneeze_4,
                R.raw.man_sneeze_5,
                R.raw.man_sneeze_6,
                R.raw.man_sneeze_7
        };
    }

    public static int[] flushList() {
        return new int[]{
                R.raw.toilet_flush_1,
                R.raw.toilet_flush_2,
                R.raw.toilet_flush_3,
                R.raw.toilet_flush_4,
                R.raw.toilet_flush_5,
                R.raw.toilet_flush_6,
                R.raw.toilet_flush_7,
                R.raw.toilet_flush_8
        };
    }

    public static int[] scaryList() {
        return new int[]{
                R.raw.scary_1,
                R.raw.scary_2,
                R.raw.scary_3,
                R.raw.scary_4,
                R.raw.scary_5,
                R.raw.scary_6,
                R.raw.scary_7,
                R.raw.scary_8,
                R.raw.scary_9,
                R.raw.scary_10
        };
    }

    public static int[] manCoughList() {
        return new int[]{
                R.raw.man_cough_1,
                R.raw.man_cough_2,
                R.raw.man_cough_3,
                R.raw.man_cough_4,
                R.raw.man_cough_5,
                R.raw.man_cough_6,
                R.raw.man_cough_7,
                R.raw.man_cough_8,
                R.raw.man_cough_9,
                R.raw.man_cough_10,
                R.raw.man_cough_11,
                R.raw.man_cough_12,
                R.raw.man_cough_13,
                R.raw.man_cough_14
        };
    }

    public static int[] gunList() {
        return new int[]{
                R.raw.gun_1,
                R.raw.gun_2,
                R.raw.gun_3,
                R.raw.gun_4,
                R.raw.gun_5,
                R.raw.gun_6,
                R.raw.gun_7,
                R.raw.gun_8,
                R.raw.gun_9,
                R.raw.gun_10,
                R.raw.gun_11,
                R.raw.gun_12,
                R.raw.gun_13,
                R.raw.gun_14
        };
    }

    public static int[] laughList() {
        return new int[]{
                R.raw.laugh_1,
                R.raw.laugh_2,
                R.raw.laugh_3,
                R.raw.laugh_4,
                R.raw.laugh_5,
                R.raw.laugh_6,
                R.raw.laugh_7,
                R.raw.laugh_8,
                R.raw.laugh_9,
                R.raw.laugh_10
        };
    }

    public static int[] scissorsList() {
        return new int[]{
                R.raw.scissors_1,
                R.raw.scissors_2,
                R.raw.scissors_3,
                R.raw.scissors_4,
                R.raw.scissors_5,
                R.raw.scissors_6,
                R.raw.scissors_7,
                R.raw.scissors_8,
                R.raw.scissors_9,
                R.raw.scissors_10
        };
    }

    public static int[] womanCoughList() {
        return new int[]{
                R.raw.woman_cough_1,
                R.raw.woman_cough_2,
                R.raw.woman_cough_3,
                R.raw.woman_cough_4,
                R.raw.woman_cough_5,
                R.raw.woman_cough_6,
                R.raw.woman_cough_7,
                R.raw.woman_cough_8,
                R.raw.woman_cough_9,
                R.raw.woman_cough_10,
                R.raw.woman_cough_11,
                R.raw.woman_cough_12
        };
    }

    public static int[] womanSneezeList() {
        return new int[]{
                R.raw.woman_sneeze_1,
                R.raw.woman_sneeze_2,
                R.raw.woman_sneeze_3,
                R.raw.woman_sneeze_4,
                R.raw.woman_sneeze_5,
                R.raw.woman_sneeze_6,
                R.raw.woman_sneeze_7,
                R.raw.woman_sneeze_8,
                R.raw.woman_sneeze_9,
                R.raw.woman_sneeze_10,
                R.raw.woman_sneeze_11,
                R.raw.woman_sneeze_12
        };
    }

}
