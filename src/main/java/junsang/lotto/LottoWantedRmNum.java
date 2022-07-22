package junsang.lotto;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LottoWantedRmNum {
    public static void main(String[] args) {
        List<Integer> lotto = new ArrayList<>();

        //Array with numbers to exclude out of 45 lottery numbers
        Integer[] exceptArr = {1,2,3,4,5,6,7,8};
        //List containing the above Array
        List<Integer> exceptList = Arrays.asList(exceptArr);
        Random random = new Random();
        boolean isOverlap = false;
        while (true) {
            isOverlap = false;
            if (lotto.size() == 6) break;
            int lottoNumber = random.nextInt(45) + 1;
            if (exceptList.contains(lottoNumber)) continue;
            // Add condition to enter when you want to enter a number that must appear
            if (lotto.size() == 0) lotto.add(lottoNumber);
            else {
                for (int i = 0; i < lotto.size(); i++) {
                    if (lotto.get(i) == lottoNumber) isOverlap = true;
                }
                if (!isOverlap) lotto.add(lottoNumber);
            }

        }

        for (int i = 0; i < lotto.size(); i++) {
            for (int j = i; j < lotto.size(); j++) {
                if (lotto.get(i) > lotto.get(j)) {
                    int temp = lotto.get(i);
                    lotto.set(i, lotto.get(j));
                    lotto.set(j, temp);
                }
            }
        }

        for (int i = 0; i < lotto.size(); i++) {
            String orderType = "";
            if (i == 0) orderType = "st";
            else if (i == 1) orderType = "nd";
            else orderType = "th";
            System.out.println(i+1 + orderType + " number :  " + lotto.get(i));
        }
    }

}
