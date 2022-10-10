
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.String.valueOf;


public class TaskString {
    public static StringBuilder paragraphSorting(String text) {//сортировка абзацев в тесте по количеству предложений
        int count = 0;
        int temp;
        String tempS;
        String[] paragraphs = text.split("\n+");//разбиение текста на абзацы
        int[] countSentence = new int[paragraphs.length];//для определения количества предложений в каждом абзаце
        StringBuilder result = new StringBuilder();//отсортированный текст
        Pattern pattern = Pattern.compile("[.?!]+");//регулярное выражение для определения количества предложений
        for (int i = 0; i < paragraphs.length; i++) {
            Matcher matcher = pattern.matcher(paragraphs[i]);
            while (matcher.find()) {//определение количества предложений для каждого абзаца
                count++;
            }
            countSentence[i] = count;
            count = 0;
        }
        for (int i = 0; i < paragraphs.length - 1; i++) {//сортировка абзацев по количеству предложений
            for (int j = i + 1; j < paragraphs.length; j++) {
                if (countSentence[j] < countSentence[i]) {
                    temp = countSentence[i];
                    countSentence[i] = countSentence[j];
                    countSentence[j] = temp;
                    tempS = paragraphs[i];
                    paragraphs[i] = paragraphs[j];
                    paragraphs[j] = tempS;
                }
            }
        }
        for (String paragraph : paragraphs) {
            result.append("\n").append(paragraph);

        }
        return result;
    }

    public static StringBuilder wordSortingChar(String text, String symbol) {//сортировка слов по количеству вхождений символа
        StringBuilder result = new StringBuilder();
        String tempS;
        int temp;
        Pattern sentence = Pattern.compile("[^.?!]+([.?!]+\\n*)");//регулярное выражение: предложение
        Matcher matcher = sentence.matcher(text);//поисковик для определения предложений
        Pattern symbolP = Pattern.compile(symbol);//регулярное выражение:заданный символ
        while (matcher.find()) {
            String[] words = matcher.group().split("[\\s.,:;-]");//разбиение предложения на слова
            int[] countSymbol = new int[words.length];//количество вхождений символа по словам
            for (int i = 0; i < words.length; i++) {//определение количества вхождений символа по словам
                Matcher matcherSymbol = symbolP.matcher(words[i]);
                while (matcherSymbol.find()) {
                    countSymbol[i]++;
                }
            }
            for (int i = 0; i < words.length - 1; i++) {
                for (int j = i + 1; j < words.length; j++) {
                    if (countSymbol[j] > countSymbol[i]) {//сортировка слов в предложении по возрастанию вхождений символа
                        tempS = words[j];
                        words[j] = words[i];
                        words[i] = tempS;
                        temp = countSymbol[j];
                        countSymbol[j] = countSymbol[i];
                        countSymbol[i] = temp;
                    } else if (countSymbol[j] == countSymbol[i]) {//сортировка по алфавиту в случае равенств вхождений символа
                        if (words[j].compareToIgnoreCase(words[i]) < 0) {
                            tempS = words[j];
                            words[j] = words[i];
                            words[i] = tempS;
                            temp = countSymbol[j];
                            countSymbol[j] = countSymbol[i];
                            countSymbol[i] = temp;
                        }
                    }
                }
            }
            for (int i = 0; i < words.length - 1; i++) {//вывод отсортированных слов
                result.append(words[i]).append(" ");
            }
            result.append(words[words.length - 1]).append(matcher.group(1));
        }
        return result;
    }

    public static StringBuilder wordSorting(String text) {//сортировка слов по длине в предложении
        StringBuilder result = new StringBuilder();
        String temp;
        Pattern sentence = Pattern.compile("[^.?!]+([.?!]+\\n*)");//регулярное выражение: предложение
        Matcher matcher = sentence.matcher(text);//поисковик для определения предложений
        while (matcher.find()) {
            String[] words = matcher.group().split("[\\s.,:;-]");//разбиение предложения на слова
            for (int i = 0; i < words.length - 1; i++) {//сортировка слов в предложении
                for (int j = i + 1; j < words.length; j++) {
                    if (words[j].length() < words[i].length()) {
                        temp = words[j];
                        words[j] = words[i];
                        words[i] = temp;
                    }
                }
            }
            for (int i = 0; i < words.length - 1; i++) {//вывод слов, отсортированных по длине
                result.append(words[i]).append(" ");
            }
            result.append(words[words.length - 1]).append(matcher.group(1));

        }
        return result;
    }

    public static String task1_1() {
        //1. Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.
        String[] variables = {"maxVariable", "minVariable", "countVariable", "arrayVariable", "sumVariable"};
        StringBuilder result = new StringBuilder();//для записи результата
        for (int i = 0; i < variables.length; i++) {
            for (int j = 0; j < variables[i].length(); j++) { //преобразование названий в snake_case и запись результата
                if (Character.isUpperCase(variables[i].charAt(j))) {
                    result.append("_").append(valueOf(variables[i].charAt(j)).toLowerCase());
                } else {
                    result.append(variables[i].charAt(j));
                }
            }
            if (i < variables.length - 1) {
                result.append(", ");
            }
        }
        return "________________________________\n\n1. Дан массив названий переменных в camelCase. " +
                "\nПреобразовать названия в snake_case. " + "\n\nОтвет:\nИсходный массив: " + Arrays.toString(variables) +
                "\nРезультат: " + result;
    }

    public static String task1_2() {
        //2. Замените в строке все вхождения 'word' на 'letter'.
        String text = "Messages that contain the word or name you specified appear with the" +
                " search text highlighted in the results. Display the word Facebook in the same font size " +
                "and style as the text surrounding it. It is doubled to place a word in all caps; " +
                "this must be repeated for each word of an all-cap text.";
        StringBuilder result = new StringBuilder();
        int count = 0;//для определения индекса, с которого начинать поиск следующего слова word
        do {
            for (int i = count; i < text.indexOf("word", count); i++) {
                result.append(text.charAt(i)); //добавление символов до слова word
            }
            count = text.indexOf("word", count) + 4;//индекс, с которого нужно начинать поиск следующего слова word
            result.append("letter"); //замена word на letter
        }
        while (text.indexOf("word", count) != -1); //пока есть слова word
        if (count < text.length()) { //добавление символов после последнего слова word
            for (int i = count; i < text.length(); i++) {
                result.append(text.charAt(i));
            }
        }
        return "\n________________________________\n\n2. Замените в строке все вхождения 'word' на 'letter'." +
                "\n\nОтвет:\nИсходная строка: " + text + "\nРезультат: " + result;
    }


    public static String task1_3() {
        //3. В строке найти количество цифр.
        String text = "2, 4, 6, 8, 10, 12, 14, 16, 18, 20\nOur legs, our arms, our hands, our feet\n" +
                "We count in pairs of two.\n2, 4, 6, 8, 10, 12, 14, 16, 18, 20\nOur eyes, our ears, our socks, our shoes," +
                "\nWe count on me and you...";
        int count = 0;//для определения количества цифр в строке text
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                count++;
            }
        }
        return "\n________________________________\n\n3. В строке найти количество цифр." + "\n\nОтвет:\nИсходная строка:\n" +
                text + "\n\nКоличество цифр в тексте: " + count;
    }

    public static String task1_4() {
        //4. В строке найти количество чисел.
        String text = "2, 4, 6, 8, 10, 12, 14, 16, 18, 20\nOur legs, our arms, our hands, our feet\n" +
                "We count in pairs of two.\n2, 4, 6, 8, 10, 12, 14, 16, 18, 20\nOur eyes, our ears, our socks, our shoes," +
                "\nWe count on me and you...";
        int count = 0;//для определения количества чисел в строке text
        for (int i = 0; i < text.length() - 1; i++) {
            if (Character.isDigit(text.charAt(i)) && !(Character.isDigit(text.charAt(i + 1)))) {
                count++;
            }
        }
        return "\n________________________________\n\n4. В строке найти количество чисел." + "\n\nОтвет:\nИсходная строка:\n" +
                text + "\n\nКоличество чисел в тексте: " + count;
    }

    public static String task1_5() {
        //5. Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов заменить на одиночные пробелы.
        //Крайние пробелы в строке удалить.
        String text = "          Messages      that     contain the word or name you specified appear with the" +
                " search text highlighted in the results.        Display the word   Facebook in the same font size " +
                "and style as the text surrounding it.      ";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length() - 1; i++) {
            //удаление лишних пробелов
            if (!(valueOf(text.charAt(i)).equals(" ") && valueOf(text.charAt(i + 1)).equals(" "))) {
                result.append(text.charAt(i));
            }
        }
        if (valueOf(result.charAt(0)).equals(" ")) {//удаление пробела в начале при его наличии
            result.deleteCharAt(0);
        }
        return "\n________________________________\n\n5. Удалить в строке все лишние пробелы, то есть серии подряд" +
                "\nидущих пробелов заменить на одиночные пробелы.\nКрайние пробелы в строке удалить." + "\n\nОтвет:" +
                "\nИсходная строка:\n" + text + "\nРезультат:\n" + result;
    }

    public static String task2_1() {
        //1. Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем.
        String text = "Messages      that     contain the word or name you specified appear with the" +
                " search text highlighted in the results.       Display the word   Facebook in the same font size " +
                "and style as the text surrounding it.";
        int max = 0;//максимальное число пробелов
        int count = 0;//количество пробелов
        for (int i = 0; i < text.length(); i++) {
            if (valueOf(text.charAt(i)).equals(" ")) {//определение количества подряд идущих пробелов
                count = 1;
                while (valueOf(text.charAt(++i)).equals(" ")) {
                    count++;
                }
            }
            if (count > max) {//определение максимального количества подряд идущих пробелов
                max = count;
                count = 0;
            }
        }
        return "\n________________________________\n\n1. Дан текст (строка). Найдите наибольшее\nколичество подряд" +
                " идущих пробелов в нем." + "\n\nОтвет:" + "\nИсходная строка:\n" + text + "\nМаксимальное число подряд" +
                "идущих пробелов: " + max;
    }

    public static String task2_2() {
        //2. В строке вставить после каждого символа 'a' символ 'b'.
        StringBuilder text = new StringBuilder("Messages that contain the word or name you specified appear with the" +
                " search text highlighted in the results. Display the word Facebook in the same font size " +
                "and style as the text surrounding it.");
        StringBuilder textNew = new StringBuilder(text); //новый тест
        for (int i = 0; i < textNew.length(); i++) {
            if (valueOf(textNew.charAt(i)).equals("a")) { //если в тексте найден символ а
                textNew.insert(i + 1, "b"); //добавление символа b
                i++;
            }
        }
        return "\n________________________________\n\n2. В строке вставить после каждого символа 'a' символ 'b'."
                + "\n\nОтвет:" + "\nИсходная строка:\n" + text + "\nНовая строка с добавлением b после a:\n" +
                textNew;
    }

    public static String task2_3(String word) {
        //3. Проверить, является ли заданное слово палиндромом.
        if (new StringBuilder(word).reverse().toString().equalsIgnoreCase(word)) {//проверка является ли слово палиндромом
            return "\n________________________________\n\n3. Проверить, является ли заданное слово палиндромом."
                    + "\n\nОтвет:" + "\nСлово " + word + " является палиндромом";
        } else {
            return "\n________________________________\n\n3. Проверить, является ли заданное слово палиндромом."
                    + "\n\nОтвет:" + "\nСлово " + word + " не является палиндромом";
        }
    }

    public static String task2_4() {
        //4. С помощью функции копирования и операции конкатенации составить из частей слова “информатика” слово “торт”.
        String word = "информатика";
        String wordNew;
        wordNew = word.substring(7, 8).concat(word.substring(3, 5)).concat(word.substring(7, 8));//получение слова торт
        return "\n________________________________\n\n4. С помощью функции копирования и операции конкатенации составить" +
                "\nиз частей слова “информатика” слово “торт”." + "\n\nОтвет:" + "\nИсходное слово: " + word +
                "\nПолученное слово: " + wordNew;
    }

    public static String task2_5() {
        //5. Подсчитать, сколько раз среди символов заданной строки встречается буква “а”.
        StringBuilder text = new StringBuilder("Messages that contain the word or name you specified appear with the" +
                " search text highlighted in the results. Display the word Facebook in the same font size " +
                "and style as the text surrounding it.");
        int count = 0;//количество "а"
        for (int i = 0; i < text.length(); i++) {
            if (valueOf(text.charAt(i)).equalsIgnoreCase("a")) {//поиск "а" в тексте
                count++;
            }
        }
        return "\n________________________________\n\n5. Подсчитать, сколько раз среди символов заданной строки" +
                "встречается буква “а”." + "\n\nОтвет:" + "\nИсходный текст:\n" + text + "\nКоличество букв a: " + count;
    }

    public static String task2_6() {
        //6. Из заданной строки получить новую, повторив каждый символ дважды.
        StringBuilder text = new StringBuilder("There are different kinds of animals on our planet, and all of them are" +
                " very important for it.");
        StringBuilder textNew = new StringBuilder(text); //новый тест
        for (int i = 0; i < textNew.length(); i++) {
            textNew.insert(i + 1, textNew.charAt(i));//добавление каждого символа по второму разу
            i++;
        }
        return "\n________________________________\n\n6. Из заданной строки получить новую, повторив каждый символ дважды."
                + "\n\nОтвет:" + "\nИсходная строка:\n" + text + "\nНовая строка:\n" + textNew;
    }

    public static String task2_7() {
        //7. Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы.
        StringBuilder text = new StringBuilder("There are different kinds of animals on our planet, and all of them are" +
                " very important for it.");
        StringBuilder textNew = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            //проверяем каждый символ строки: если он не встречался в новой строке и не равен пробелу, добавляем в новую строку
            if (textNew.indexOf(valueOf(text.charAt(i))) == -1 && !valueOf(text.charAt(i)).equals(" ")) {
                textNew.append(text.charAt(i));
            }
        }
        return "\n________________________________\n\n7. Вводится строка. Требуется удалить из нее повторяющиеся символы " +
                "и все пробелы." + "\n\nОтвет:" + "\nИсходная строка:\n" + text + "\nНовая строка:\n" + textNew;
    }

    public static String task2_8() {
        //8. Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран.
        // Случай, когда самых длинных слов может быть несколько, не обрабатывать.
        String text = "There are different kinds of animals on our planet, and all of them are" +
                " very important for it.";
        String[] words = text.split(" ");//создание массива слов из строки text
        int maxLength = 0; //количество символов в самом длинном слове
        String maxWord = "";//самое длинное слово
        for (String word : words) {
            if (word.length() > maxLength) { //поиск максимального слова и его длины
                maxLength = word.length();
                maxWord = word;
            }
        }
        return "\n________________________________\n\n8. Вводится строка слов, разделенных пробелами. \nНайти самое длинное " +
                "слово и вывести его на экран." + "\n\nОтвет:" + "\nИсходная строка:\n" + text + "\nСамое длинное слово: " +
                maxWord + "\nКоличество символов в самом длинном слове: " + maxLength;
    }

    public static String task2_9() {
        //9. Посчитать количество строчных (маленьких) и прописных (больших) букв в веденной строке.
        // Учитывать только английские буквы.
        String text = "There are different kinds of animals on our planet, and all of them are" +
                " very important for it.";
        int countUpperCase = 0; //количество символов в нижнем регистре
        int countLowerCase = 0; //количество символов в верхнем регистре
        for (int i = 0; i < text.length(); i++) {
            if (valueOf(text.charAt(i)).matches("[A-Z]")) {//определение количества символов в нижнем регистре
                countLowerCase++;
            } else {
                if (valueOf(text.charAt(i)).matches("[a-z]")) {//определение количества символов в верхнем регистре
                    countUpperCase++;
                }
            }
        }
        return "\n________________________________\nПосчитать количество строчных (маленьких) и прописных (больших) букв" +
                "\nв введенной строке. Учитывать только английские буквы." + "\n\nОтвет:" + "\nИсходная строка:\n" + text +
                "\nКоличество символов в нижнем регистре: " + countLowerCase + "\nКоличество символов верхнем регистре: "
                + countUpperCase;
    }

    public static String task2_10() {
        //10. Строка X состоит из нескольких предложений, каждое из которых кончается точкой, восклицательным или
        //вопросительным знаком. Определить количество предложений в строке X.
        String text = "Messages that contain the word or name you specified appear with the" +
                " search text highlighted in the results. Display the word Facebook in the same font size " +
                "and style as the text surrounding it. It is doubled to place a word in all caps; " +
                "this must be repeated for each word of an all-cap text.";
        int countSentence = 0; //количество предложений в строке
        for (int i = 0; i < text.length(); i++) {
            if (valueOf(text.charAt(i)).matches("[?!.]")) {//поиск количества предложений в строке
                countSentence++;
            }
        }
        return "\n________________________________\n10. Строка X состоит из нескольких предложений, каждое из которых" +
                "\nкончается точкой, восклицательным или вопросительным знаком.\nОпределить количество предложений в строке X." +
                "\n\nОтвет:" + "\nИсходная строка:\n" + text + "\nКоличество предложений в строке: " + countSentence;
    }

    public static String task3_1() {
        /*1. Создать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три различных
        операции: отсортировать абзацы по количеству предложений; в каждом предложении отсортировать слова по длине;
        отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства
        – по алфавиту.*/
        String text = "To advertise means to make information public. But nowadays advertising does not limit itself by a" +
                " word ‘publicity’. Modern advertising has a task to show a product in a positive and pleasant way." +
                " It has an aim to make us want to buy it.\n" +
                "The advertisement has existed since antiquity time. At first there were murals that informed about" +
                " gladiator fights. In the middle Ages public heralds stood in the centre of the city and gave last news.\n" +
                "In the 15th century there was a good development of printing. After that posters and leaflets appeared.\n" +
                "In the United States companies have worked with advertisers since 1930.\n" +
                "Nowadays the new territory of commercials is Internet with social networks. Small software called cookies" +
                "allows offering ads according to the tastes of Internet users.";
        return "\n________________________________\n1. Создать приложение, разбирающее текст (текст хранится в строке)\n" +
                "и позволяющее выполнять с текстом три различных\nоперации: отсортировать абзацы по количеству предложений;\n" +
                "в каждом предложении отсортировать слова по длине;\nотсортировать лексемы в предложении по убыванию\n" +
                "количества вхождений заданного символа, а в случае равенства – по алфавиту.\n\nОтвет:" +
                "\nИсходная строка:\n\n" + text + "\n\n1. Сортировка абзацев по количеству предложений: \n"
                + paragraphSorting(text) + "\n\n2. Сортировка слов в предложениях по длине: \n\n" + wordSorting(text) +
                "\n\n3. Сортировка слов в предложениях по количеству вхождений заданного символа, в случае равенства " +
                "вхождений символа - по алфавиту : \n\n" + wordSortingChar(text, "i");
    }

    public static String task3_2() {
        /*2. Дана строка, содержащая текст (xml-документ). Напишите анализатор, позволяющий последовательно возвращать
        содержимое узлов xml-документа и его тип*/
        String text = "<notes>\n" +
                "<note id = 1>\n" +
                "<to>Вася</to>\n" +
                "<from>Света</from>\n" +
                "<heading>Напоминание</heading>\n" +
                "<body>Позвони мне завтра!</body>\n" +
                "</note>\n" +
                "<note id = 2>\n" +
                "<to>Петя</to>\n" +
                "<from>Маша</from>\n" +
                "<heading>Важное напоминание</heading>\n" +
                "<body/>\n" +
                "</note>\n" +
                "</notes>";
        StringBuilder result = new StringBuilder();
        Pattern pattern = Pattern.compile("(<[^/]+?[^/]>)|((?<=>).+?(?=<))|(</.+?[^/]>)|(<.+?/>)");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            if (matcher.group().equals(matcher.group(1))) {
                result.append("\nОткрывающий тег: ").append(matcher.group());
            } else if (matcher.group().equals(matcher.group(2))) {
                result.append("\nСодержимое тега: ").append(matcher.group());
            } else if (matcher.group().equals(matcher.group(3))) {
                result.append("\nЗакрывающий тег: ").append(matcher.group());
            } else {
                result.append("\nТег без тела: ").append(matcher.group());
            }
        }
        return "\n________________________________\n2. Дана строка, содержащая текст (xml-документ). Напишите анализатор," +
                "\nпозволяющий последовательно возвращать содержимое узлов xml-документа и его тип\n\nОтвет:" +
                "\nИсходная строка:\n\n" + text + "\nРезультат:" + result;
    }

    public static void main(String[] args) {
        String result;
        System.out.println("\nРабота со строкой как с массивом символов");
        result = task1_1();
        System.out.println(result);
        result = task1_2();
        System.out.println(result);
        result = task1_3();
        System.out.println(result);
        result = task1_4();
        System.out.println(result);
        result = task1_5();
        System.out.println(result);
        System.out.println("\nРабота со строкой как с объектом типа String или StringBuilder");
        result = task2_1();
        System.out.println(result);
        result = task2_2();
        System.out.println(result);
        result = task2_3("Шалаш");
        System.out.println(result);
        result = task2_4();
        System.out.println(result);
        result = task2_5();
        System.out.println(result);
        result = task2_6();
        System.out.println(result);
        result = task2_7();
        System.out.println(result);
        result = task2_8();
        System.out.println(result);
        result = task2_9();
        System.out.println(result);
        result = task2_10();
        System.out.println(result);
        System.out.println("\nРабота с регулярными выражениями (Pattern, Matcher)");
        result = task3_1();
        System.out.println(result);
        result = task3_2();
        System.out.println(result);
    }
}
