import java.util.HashSet;
import java.util.Set;

public class UniqueCharactersMerger {

    public static void main(String[] args) {
        String[] metinDizisi = {"mücahit", "besli", "test", "otomasyon", "kursu"};

        // İçinde tekrarlı karakterler bulunan iki metni seç
        String[] secilenMetinler = findTwoTextsWithDuplicateCharacters(metinDizisi);

        // İki metni birleştir ve benzersiz karakter kümesini bul.
        String birlesikMetin = mergeAndFindUniqueCharacters(secilenMetinler[0], secilenMetinler[1]);

        System.out.println("Birleştirilen Metin: " + birlesikMetin);
    }

    public static String[] findTwoTextsWithDuplicateCharacters(String[] metinDizisi) {
        String[] secilenMetinler = new String[2];
        boolean metinBulundu = false;

        for (int i = 0; i < metinDizisi.length - 1; i++) {
            for (int j = i + 1; j < metinDizisi.length; j++) {
                if (hasDuplicateCharacters(metinDizisi[i]) && hasDuplicateCharacters(metinDizisi[j])) {
                    secilenMetinler[0] = metinDizisi[i];
                    secilenMetinler[1] = metinDizisi[j];
                    metinBulundu = true;
                    break;
                }
            }
            if (metinBulundu) {
                break;
            }
        }

        return secilenMetinler;
    }

    public static boolean hasDuplicateCharacters(String metin) {
        Set<Character> karakterSeti = new HashSet<>();
        for (char karakter : metin.toCharArray()) {
            if (!karakterSeti.add(karakter)) {
                return true; // Tekrar eden karakter bulundu
            }
        }
        return false; // Tekrar eden karakter bulunamadı
    }

    public static String mergeAndFindUniqueCharacters(String metin1, String metin2) {
        // Metinleri birleştir
        String birlesikMetin = metin1 + metin2;

        // Benzersiz karakter kümesini oluştur
        Set<Character> benzersizKarakterKumesi = new HashSet<>();
        for (char karakter : birlesikMetin.toCharArray()) {
            benzersizKarakterKumesi.add(karakter);
        }

        // Benzersiz karakter kümesini yeni bir metin olarak birleştir
        StringBuilder birlesikMetinBuilder = new StringBuilder();
        for (Character karakter : benzersizKarakterKumesi) {
            birlesikMetinBuilder.append(karakter);
        }

        return birlesikMetinBuilder.toString();
    }
}
