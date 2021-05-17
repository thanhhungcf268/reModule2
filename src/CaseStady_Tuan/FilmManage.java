package CaseStady_Tuan;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilmManage {
    public static final String URL1 = "https://www.boxofficemojo.com/weekend/2021W17/?ref_=bo_hm_rw";
    public static final String URL2 = "https://www.boxofficemojo.com/chart/top_lifetime_gross/?area=XWW";
    public static final String CRAWL_CODE1 = "<a class=\"a-link-normal\" href=\"/release/rl(.*?)/?ref_=bo_we_table_(.*?)\">(.*?)</a>";
    public static final String CRAWL_CODE2 = "<a class=\"a-link-normal\" href=\"/title/tt(.*?)/?ref_=bo_cso_table_(.*?)\">(.*?)</a>";
    public static final String FILE_FILM = "FilmData.txt";
    public static final String WRONG_ID = "This id isn't exists";
    public static final String THE_LIST_UPDATED = "The list updated";

    List<Film> filmList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    MovieSeries film1 = new MovieSeries(1, "Avatar", "High", "James", "Sam", 9.8, 2009, "Paramount", "162", 2802);
    MovieSeries film2 = new MovieSeries(2, "Avengers", "Super", "Anthony", "Stark", 8.4, 2019, "Disney", "181", 2798);
    TelevisionSeries film3 = new TelevisionSeries(3, "Game of Thrones", "Fantasy", "David", "Sean Bean", 9.3, 2011, 8, "60 minutes", "HBO");

    public void mainToy() throws IOException {
        int choice = -1;
        do {
            myMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    inputInformation();
                    break;
                case 2:
                    displayFilmInformation();
                    break;
                case 3:
                    replaceFilmById();
                    break;
                case 4:
                    deleteFilmById();
                    break;
                case 5:
                    selectionSortByImdbRate();
                    break;
                case 6:
                    selectionSortByName();
                    break;
                case 7:
                    selectionSortByReleaseYear();
                    break;
                case 8:
                    showFilmById();
                    break;
                case 9:
                    showBestMovieByMoney();
                    break;
                case 10:
                    showTelevisionSeriesByTheMostSeasons();
                    break;
                case 11:
                    writeDataToFile();
                    break;
                case 12:
                    ShowDataFromReadFile();
                    break;
                case 13:
                    top10WeekBoxOfficeMojo();
                    break;
                case 14:
                    top20AllTimeWorldWide();
                    break;
                case 15:

                    break;
                case 0:
                    System.exit(0);
            }
        }
        while (choice != 0);
    }

    public void writeDataToFile() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_FILM));
            oos.writeObject(filmList);
            oos.close();
            System.out.println("Success!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ShowDataFromReadFile() {
        List<Film> b = readData();
        for (Film a : b) {
            System.out.println(a);
        }
    }

    public List<Film> readData() {
        List<Film> x = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_FILM));
            x = (List<Film>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return x;
    }

    public void showTelevisionSeriesByTheMostSeasons() {
        double max = 0;
        int index = -1;
        for (int i = 0; i < filmList.size(); i++) {
            if (filmList.get(i) instanceof TelevisionSeries) {
                if (((TelevisionSeries) filmList.get(i)).getNumberOfSeasons() > max) {
                    max = ((TelevisionSeries) filmList.get(i)).getNumberOfSeasons();
                    index = i;
                }
            }
        }
        System.out.println("The television series with the most seasons is: ");
        System.out.println(filmList.get(index));
    }

    public void showFilmById() {
        int index = checkId();
        if (index == -1) {
            System.out.println(WRONG_ID);
            showFilmById();
        } else {
            System.out.println(filmList.get(index));
        }
    }

    public void showBestMovieByMoney() {
        double max = 0;
        int index = -1;
        for (int i = 0; i < filmList.size(); i++) {
            if (filmList.get(i) instanceof MovieSeries) {
                if (((MovieSeries) filmList.get(i)).getWorldWideBoxOffice() > max) {
                    max = ((MovieSeries) filmList.get(i)).getWorldWideBoxOffice();
                    index = i;
                }
            }
        }
        System.out.println("The movie with the best world wide Box Office is: ");
        System.out.println(filmList.get(index));
    }

    public void selectionSortByReleaseYear() {
        for (int i = 0; i < filmList.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < filmList.size(); j++)
                if (filmList.get(j).getReleaseYear() < filmList.get(min).getReleaseYear())
                    min = j;
            Film temp = filmList.get(min);
            filmList.set(min, filmList.get(i));
            filmList.set(i, temp);
        }
        System.out.println(THE_LIST_UPDATED);
    }

    public void selectionSortByName() {
        for (int i = 0; i < filmList.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < filmList.size(); j++)
                if (filmList.get(j).getName().compareTo(filmList.get(min).getName()) < 0) {
                    min = j;
                }
            Film temp = filmList.get(i);
            filmList.set(i, filmList.get(min));
            filmList.set(min, temp);
        }
        System.out.println(THE_LIST_UPDATED);
    }

    public void selectionSortByImdbRate() {
        for (int i = 0; i < filmList.size() - 1; i++) {
            int max = i;
            for (int j = i + 1; j < filmList.size(); j++)
                if (filmList.get(j).getImdbRate() > filmList.get(max).getImdbRate())
                    max = j;
            Film temp = filmList.get(max);
            filmList.set(max, filmList.get(i));
            filmList.set(i, temp);
        }
        System.out.println(THE_LIST_UPDATED);
    }

    public void deleteFilmById() {
        int check = checkId();
        if (check == -1) {
            System.out.println(WRONG_ID);
            deleteFilmById();
        } else {
            filmList.remove(check);
            System.out.println(THE_LIST_UPDATED);
        }
    }

    public void myMenu() {
        System.out.println();
        System.out.println("WELCOME");
        System.out.println("1: Add a movie information                  8: Show film by id");
        System.out.println("2: Show all movies information              9: Show best revenue movie series");
        System.out.println("3: Replace movie by id                      10: Show TV series with the most seasons");
        System.out.println("4: Delete movie by id                       11: Write data to file");
        System.out.println("5: Sort movie by imdb rate                  12: Read data from file");
        System.out.println("6: Sort movie by name                       13: Show top 10 best movies in week on boxOfficeMojo");
        System.out.println("7: Sort movie by release year               14: Show top 20 movies of all time on boxOfficeMojo");
        System.out.println("0: Exit");
        System.out.println("Enter Code");
        System.out.println("_________________________________________________________________________________________________");
    }

    public void selectionSortById() {
        for (int i = 0; i < filmList.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < filmList.size(); j++)
                if (filmList.get(j).getId() < filmList.get(min).getId())
                    min = j;
            Film temp = filmList.get(min);
            filmList.set(min, filmList.get(i));
            filmList.set(i, temp);
        }
    }

    public void replaceFilmById() {
        int check = checkId();
        if (check == -1) {
            System.out.println(WRONG_ID);
            replaceFilmById();
        } else {
            if (filmList.get(check) instanceof MovieSeries) {
                filmList.set(check, inputMovieInformation());
            } else if (filmList.get(check) instanceof TelevisionSeries) {
                filmList.set(check, inputTelevisionInformation());
            }
        }
    }

    public int checkId() {
        Scanner sc = new Scanner(System.in);
        selectionSortById();
        System.out.println("Enter the id that you want to check: ");
        int key = sc.nextInt();
        int index = -1;
        int left = 0;
        int right = filmList.size() - 1;
        do {
            int mid = (left + right) / 2;
            if (key == filmList.get(mid).getId()) {
                index = mid;
                return index;
            } else if (key < filmList.get(mid).getId()) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        } while (left <= right);
        return -1;
    }


    public void displayFilmInformation() {
        for (Film x : filmList) {
            System.out.println(x);
        }
    }

    public void inputInformation() {
        int key = -1;
        do {
            System.out.println("1: Input a movie series");
            System.out.println("2: Input a television series");
            key = sc.nextInt();
            if (key == 1) {
                filmList.add(inputMovieInformation());
                break;
            } else if (key == 2) {
                filmList.add(inputTelevisionInformation());
                break;
            }
        } while (key != 1 || key != 2);
    }

    public Film inputTelevisionInformation() {
        System.out.println("Input film information");
        System.out.println("Input id: ");
        int id = reEnterIfTheIdAlreadyExists();
        System.out.println("Input name: ");
        String name = sc.next();
        System.out.println("Input film genre: ");
        String filmGenre = sc.next();
        System.out.println("Input director: ");
        String director = sc.next();
        System.out.println("Inout main stars: ");
        String mainStars = sc.next();
        System.out.println("Input imdb rate: ");
        double imdbRate = sc.nextDouble();
        System.out.println("Input release year: ");
        int releaseYear = sc.nextInt();
        System.out.println("Input number of seasons: ");
        int numberOfSeasons = sc.nextInt();
        System.out.println("Input avg episode length: ");
        String avgEpisodeLength = sc.next();
        System.out.println("Input release platform: ");
        String releasePlatform = sc.next();
        return new TelevisionSeries(id, name, filmGenre, director, mainStars,
                imdbRate, releaseYear, numberOfSeasons, avgEpisodeLength, releasePlatform);
    }

    public Film inputMovieInformation() {
        System.out.println("Input film information");
        System.out.println("Input id: ");
        int id = reEnterIfTheIdAlreadyExists();
        System.out.println("Input name: ");
        String name = sc.next();
        System.out.println("Input film genre: ");
        String filmGenre = sc.next();
        System.out.println("Input director: ");
        String director = sc.next();
        System.out.println("Inout main stars: ");
        String mainStars = sc.next();
        System.out.println("Input imdb rate: ");
        double imdbRate = sc.nextDouble();
        System.out.println("Input release year: ");
        int releaseYear = sc.nextInt();
        System.out.println("Input distributed: ");
        String distributedBy = sc.next();
        System.out.println("Input running time: ");
        String runningTime = sc.next();
        System.out.println("Input world wide BoxOffice: ");
        double worldWideBoxOffice = sc.nextDouble();
        return new MovieSeries(id, name, filmGenre, director, mainStars, imdbRate,
                releaseYear, distributedBy, runningTime, worldWideBoxOffice);
    }

    public int reEnterIfTheIdAlreadyExists() {
        int id;
        try {
            id = sc.nextInt();
            for (int i = 0; i < filmList.size(); i++) {
                if (filmList.get(i).getId() == id) {
                    System.out.println("This id already exists");
                    sc.nextLine();
                    return reEnterIfTheIdAlreadyExists();
                }
            }
        } catch (Exception e) {
            System.out.println("Sai kiểu dữ liệu");
            sc.nextLine();
            return reEnterIfTheIdAlreadyExists();
        }
        return id;
    }

    public void top10WeekBoxOfficeMojo() throws IOException {
        System.out.println("Top 10 best movies in this week by TopBoxOfficeMojo: ");
        URL url = new URL(URL1);
        Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
        scanner.useDelimiter("\\Z");
        String content = scanner.next();
        scanner.close();
        content = content.replaceAll("\\n+", "");
        Pattern p = Pattern.compile(CRAWL_CODE1);
        Matcher m = p.matcher(content);
        showDataFormWeb(m, 10);
    }

    public void top20AllTimeWorldWide() throws IOException {
        System.out.println("Top 20 all time best movies by TopBoxOfficeMojo: ");
        URL url = new URL(URL2);
        Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
        scanner.useDelimiter("\\Z");
        String content = scanner.next();
        scanner.close();
        content = content.replaceAll("\\n+", "");
        Pattern p = Pattern.compile(CRAWL_CODE2);
        Matcher m = p.matcher(content);
        showDataFormWeb(m, 20);
    }

    public static void showDataFormWeb(Matcher m, int x) {
        int i = 0;
        while (m.find()) {
            if (i == x) {
                break;
            }
            System.out.println(m.group(3));
            i++;
        }
    }
}
