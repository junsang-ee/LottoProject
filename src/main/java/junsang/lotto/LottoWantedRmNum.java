package junsang.lotto;


import java.util.*;

public class LottoWantedRmNum {
    public static void main(String[] args) {
        List<Integer> lottoNumbers = new ArrayList<>();

        //Array with numbers to exclude out of 45 lottery numbers
        Integer[] exceptArr = {20,23,24};
        //List containing the above Array
        List<Integer> exceptList = Arrays.asList(exceptArr);

        Random random = new Random();
        int randomLottoNumber = 0;
        while (lottoNumbers.size() < 6) {
            randomLottoNumber = random.nextInt(45) + 1;
            if (exceptList.contains(randomLottoNumber)) continue;
            if (!lottoNumbers.contains(randomLottoNumber))
                lottoNumbers.add(randomLottoNumber);
        }
        Collections.sort(lottoNumbers);
        String order = "";
        int index = 0;
        for (int number : lottoNumbers) {
            index++;
            if (index == 1) order = "st";
            else if (index == 2) order ="nd";
            else order = "th";
            System.out.println(index + order + " : " + number);
        }
    }

}
