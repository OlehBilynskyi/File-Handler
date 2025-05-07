package app;
//Підключаємо готові класи, щоб працювати з файлами.

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class FileHandler {
    //Змінна класу, яка зберігає шлях до папки files, ми будемо працювати з файлами всередині цієї папки
    private final static String BASE_PATH = "files/";

    //Метод writeFile приймає ім'я файлу та текст який треба записати в цей файл, повертає рядок Success або Failed
    public String writeFile(String fileName, String fileContent) {
        //Починаємо блок try, щоб спробувати виконати операції з файлами, якщо станеться помилка, то зловимо її в catch
        try {
            //Створюємо об'єкт folder, який вказує на папку files
            File folder = new File(BASE_PATH);
            //Якщо папка ще не існує, тоді створюємо її методом mkdir()
            // Результат (true або false) зберігається у isCreated.
            if (!folder.exists()) {
                boolean isCreated = folder.mkdir();
                if (isCreated) {
                    System.out.println("The 'files' folder was created successfully.");
                } else {
                    System.out.println("Failed to create the 'files' folder.");
                    return "Failed.";
                }
                //Якщо папка існує, то просто повідомляємо це в консоль
            } else {
                System.out.println("The 'files' folder already exists.");
            }

            //Створюємо об'єкт FileWriter, щоб записати файл files/my_file.txt.
            //Якщо такого файлу немає, він створиться автоматично
            FileWriter fw = new FileWriter(BASE_PATH + fileName + ".txt");
            //Записуємо вміст файлу(текст який передався у fileContent)
            fw.write(fileContent);
            //Закриваємо файл після запису
            fw.close();
            return "Success.";
        } catch (IOException e) {
            return "Error: " + e.getMessage();
        }
    }

    //Метод читає вміст файлу за вказаним шляхом та повертає текст з файлу у вигляді рядка
    public String readFile(String path) {
        //Відкриваємо файл для читання (клас FileReader читає текст побуквенно),
        //try(...) автоматично закриває файл після завершення
        try (FileReader reader = new FileReader(path)) {
            //Створюємо порожній об'єкт, щоб поступово зібрати всі букви у повний текст
            StringBuilder stringBuilder = new StringBuilder();
            //Читаємо кожен символ поки не дійдемо до кінця, перетворюємо символ з int на char і додаємо до результату.
            int sym;
            while ((sym = reader.read()) != -1) {
                stringBuilder.append((char) sym);
            }
            //Перетворюємо весь зібраний текст на звичайний String і повертаємо
            return stringBuilder.toString();
            //Якщо файл не знайдено або сталась інша помилка, то повертаємо повідомлення з поясненням
        } catch (IOException ex) {
            return "Error: " + ex.getMessage();
        }
    }
}
