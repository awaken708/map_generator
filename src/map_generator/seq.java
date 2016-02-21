package map_generator;

import java.util.ArrayList;
import java.util.Random;

public class seq {

    public int[][] find(int[][] map, int x, int y) {
        map[x][y] = 1;
        ArrayList<koord> koords = new ArrayList();
        koord ko = new koord();
        ko.i = x;
        ko.j = y;
        ko.n = 1;
        koords.add(ko);

        while (true) {

            ko = koords.get(0);
            if ((ko.i > 0) && (map[ko.i - 1][ko.j] != -1)) {
                koord temp = new koord();
                temp.i = ko.i - 1;
                temp.j = ko.j;
                temp.n = ko.n + 1;
                if ((map[ko.i - 1][ko.j] > temp.n) || (map[ko.i - 1][ko.j] == 0)) {
                    map[ko.i - 1][ko.j] = temp.n;
                    koords.add(temp);
                }
            }
            if ((ko.j > 0) && (map[ko.i][ko.j - 1] != -1)) {
                koord temp = new koord();
                temp.i = ko.i;
                temp.j = ko.j - 1;
                temp.n = ko.n + 1;
                if ((map[ko.i][ko.j - 1] > temp.n) || (map[ko.i][ko.j - 1] == 0)) {
                    map[ko.i][ko.j - 1] = temp.n;
                    koords.add(temp);
                }
            }
            if ((ko.i < map[0].length - 1) && (map[ko.i + 1][ko.j] != -1)) {
                koord temp = new koord();
                temp.i = ko.i + 1;
                temp.j = ko.j;
                temp.n = ko.n + 1;
                if ((map[ko.i + 1][ko.j] > temp.n) || (map[ko.i + 1][ko.j] == 0)) {
                    map[ko.i + 1][ko.j] = temp.n;
                    koords.add(temp);
                }
            }
            if ((ko.j < map[0].length - 1) && (map[ko.i][ko.j + 1] != -1)) {
                koord temp = new koord();
                temp.i = ko.i;
                temp.j = ko.j + 1;
                temp.n = ko.n + 1;
                if ((map[ko.i][ko.j + 1] > temp.n) || (map[ko.i][ko.j + 1] == 0)) {
                    map[ko.i][ko.j + 1] = temp.n;
                    koords.add(temp);
                }
            }
            //System.out.println(koords.get(0).i+" "+koords.get(0).j+" "+koords.get(0).n);
            koords.remove(0);
            if (koords.isEmpty()) {
                break;
            }

        }
        return map;
    }

    public int[][] print_map() {
        int N = 400;
        int map[][] = new int[N][N];
        Random rand = new Random();
        int[][] find_map;
        int K = 0;
        while (true) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (rand.nextInt(100) < 40) {
                        map[i][j] = -1;
                    } else {
                        map[i][j] = 0;
                    }
                }
            }
            if (map[N - 1][N - 1] == 0) {
                find_map = find(map, 0, 0);
                if (find_map[N - 1][N - 1] > 100) {
                    break;
                }
            }

        }
        /**
         * for (int i = 0; i < N; i++) { for (int j = 0; j < N; j++) {
         * //if((find_map[j][i] == -1)||(find_map[j][i] == 0)) find_map[j][i] =
         * 0; else find_map[j][i] =1; System.out.print(find_map[j][i] + " "); }
         * System.out.println(); }*
         */
        return find_map;
    }

    public ArrayList<koord> search(ArrayList<koord> list, int N) {

        ArrayList<koord> final_map = new ArrayList();
        //for(int i = 0; i < list.size(); i++)
            //final_map.add(list.get(i));

        while (!list.isEmpty()) {
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = 0;
                }
            }
            for (int i = 0; i < final_map.size(); i++) {
                map[final_map.get(i).i][final_map.get(i).j] = -1;
            }
            map = find(map, list.get(0).i, list.get(0).j);
            list.remove(0);
            int s_i = list.get(0).i;
            int s_j = list.get(0).j;
            
            list.remove(0);
            while (true) {
                koord temp = new koord();
                boolean log = false;
                if ((s_i > 0) & (s_j > 0) & (s_i < (N - 1)) & (s_j < (N - 1))) {
                    
                    if(map[s_i][s_j] == (map[s_i+1][s_j] + 1)){
                        s_i++;
                        temp.i = s_i;
                        temp.j = s_j;
                        
                        final_map.add(temp);
                        log = true;
                    }
                    if(map[s_i][s_j] == (map[s_i-1][s_j] + 1)){
                        s_i--;
                        temp.i = s_i;
                        temp.j = s_j;
                        final_map.add(temp);
                        log = true;
                    }
                    if(map[s_i][s_j] == (map[s_i][s_j+1] + 1)){
                        s_j++;
                        temp.i = s_i;
                        temp.j = s_j;
                        final_map.add(temp);
                        log = true;
                    }
                    if(map[s_i][s_j] == (map[s_i][s_j-1] + 1)){
                        s_j--;
                        temp.i = s_i;
                        temp.j = s_j;
                        final_map.add(temp);
                        log = true;
                    }
                    if (!log) break;
                }
            }
        }
        return final_map;
    }
    
    public int[][] list_to_array(ArrayList<koord> list, int N){
        int[][] map = new int[N][N];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                map[i][j] = 0;
        for(int i = 0; i < list.size(); i++){
            map[list.get(i).i][list.get(i).j] = 1;
           // System.out.println(list.get(i).i + " " + list.get(i).j);
        }
        
        return map;
    }
}
