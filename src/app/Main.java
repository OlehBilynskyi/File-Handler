package app;

public class Main {
    //Змінна, яка зберігає шлях до папки files/
    private final static String BASE_PATH = "files/";

    public static void main(String[] args) {
        //Створюємо об'єкт FileHandler, щоб користуватись його методами;
        //тепер ми можемо викликати writeFile() і readFile().
        FileHandler handler = new FileHandler();
        //Назва майбутнього файлу
        String fileName = "my_file";
        //Текст, який буде записаний у файл
        String fileContent = "My very important information.";
        //Викликаємо метод writeFile() з назвою і вмістом, результат збережеться у змінній result (Success або Failed)
        String result = handler.writeFile(fileName, fileContent);
        //Після запису читаємо цей файл, текст з файлу зберігаємо в content
        String content = handler.readFile(BASE_PATH + fileName + ".txt");
        //Виводимо результат запису в консоль
        getOutput("Result: " + result);
        //Виводимо в консоль текст, який прочитали з файлу
        getOutput("FILE CONTENT: " + content);
    }

    //Виводимо передану інформацію в консоль
    private static void getOutput(String output) {
        System.out.println(output);
    }
}
