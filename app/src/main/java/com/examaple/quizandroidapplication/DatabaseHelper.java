package com.examaple.quizandroidapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "quiz.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_ENGLISH = "English";
    public static final String TABLE_MATHS = "Mathematics";
    public static final String TABLE_SCIENCE = "Science";
    public static final String TABLE_SOCIAL_SCIENCE = "SocialScience";
    public static final String TABLE_GENERAL_KNOWLEDGE = "GeneralKnowledge";
    public static final String TABLE_COMPUTER_SCIENCE = "ComputerScience";

    private static final String CREATE_ENGLISH_TABLE =
            "CREATE TABLE " + TABLE_ENGLISH + " (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "question TEXT, " +
                    "answer TEXT)";

    private static final String CREATE_MATHS_TABLE =
            "CREATE TABLE " + TABLE_MATHS + " (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "question TEXT, " +
                    "answer TEXT)";

    private static final String CREATE_SCIENCE_TABLE =
            "CREATE TABLE " + TABLE_SCIENCE + " (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "question TEXT, " +
                    "answer TEXT)";

    private static final String CREATE_SOCIAL_SCIENCE_TABLE =
            "CREATE TABLE " + TABLE_SOCIAL_SCIENCE + " (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "question TEXT, " +
                    "answer TEXT)";

    private static final String CREATE_GENERAL_KNOWLEDGE_TABLE =
            "CREATE TABLE " + TABLE_GENERAL_KNOWLEDGE + " (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "question TEXT, " +
                    "answer TEXT)";

    private static final String CREATE_COMPUTER_SCIENCE_TABLE =
            "CREATE TABLE " + TABLE_COMPUTER_SCIENCE + " (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "question TEXT, " +
                    "answer TEXT)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ENGLISH_TABLE);
        db.execSQL(CREATE_MATHS_TABLE);
        db.execSQL(CREATE_SCIENCE_TABLE);
        db.execSQL(CREATE_SOCIAL_SCIENCE_TABLE);
        db.execSQL(CREATE_GENERAL_KNOWLEDGE_TABLE);
        db.execSQL(CREATE_COMPUTER_SCIENCE_TABLE);
        insertQuestions(db);
    }

    public void insertQuestions(SQLiteDatabase db) {
        // Insert English questions and answers
        db.execSQL("INSERT INTO " + TABLE_ENGLISH + " (question, answer) VALUES " +
                "('What is the main theme of Shakespeare''s play ''Romeo and Juliet''?', 'The power of love and its transformative effect on individuals.'), " +
                "('In George Orwell''s ''Animal Farm'', what does the character Napoleon represent?', 'Joseph Stalin and the corrupting influence of power.'), " +
                "('Who is the author of the novel \"To Kill a Mockingbird\"?', 'Harper Lee.'), " +
                "('What does the term \"stream of consciousness\" mean in literature?', 'A narrative technique that presents the thoughts and feelings of a character as they occur.'), " +
                "('What is the significance of the green light in F. Scott Fitzgerald ''The Great Gatsby\"?', 'It symbolizes Gatsby''s hopes and dreams.'), " +
                "('Who wrote the poem ''The Road Not Taken''?', 'Robert Frost.'), " +
                "('What is the central conflict in Arthur Miller''s play ''The Crucible''?', 'The struggle between individual conscience and societal pressure.'), " +
                "('What is the literary term for a play on words, often for comedic effect?', 'Pun.'), " +
                "('Which author is known for the series of fantasy novels titled ''A Song of Ice and Fire''?', 'George R.R. Martin.'), " +
                "('What is the meaning of the literary term ''foil''?', 'A character who contrasts with another character to highlight particular qualities of the other character.')");


        // Insert Mathematics questions and answers
        db.execSQL("INSERT INTO " + TABLE_MATHS + " (question, answer) VALUES " +
                "('Solve the quadratic equation: x^2 - 5x + 6 = 0', 'Solutions: x = 2 or x = 3.'), " +
                "('Find the derivative of the function f(x) = 3x^2 + 2x - 5.', 'Derivative: f''(x) = 6x + 2.'), " +
                "('What is the value of lim_(x -> 3) (2x^2 - 5x + 1)?', 'The limit is 10.'), " +
                "('Calculate the area of a circle with radius r = 4 units.', 'Area: A = 16π square units.'), " +
                "('Find the integral of the function f(x) = 2x^3 - 6x^2 + 4x + 7.', 'Integral: F(x) = (1/2)x^4 - 2x^3 + 2x^2 + 7x + C.'), " +
                "('If a + b = 10 and ab = 24, what are the values of a and b?', 'The solutions are a = 6 and b = 4.'), " +
                "('What is the Pythagorean Theorem?', 'In a right triangle, the square of the length of the hypotenuse (c) is equal to the sum of the squares of the other two sides (a and b): c^2 = a^2 + b^2.'), " +
                "('If f(x) = 2x^2 + 3x - 5, find f(-2).', 'The value of f(-2) is -3.'), " +
                "('Solve the system of equations: 2x + 3y = 8 and 3x - 2y = 4.', 'Solutions: x = 2 and y = 1.'), " +
                "('Calculate the determinant of the matrix: |2 1|\\n|-3 4|', 'The determinant is 10.')");

        // Insert Science questions and answers
        db.execSQL("INSERT INTO " + TABLE_SCIENCE + " (question, answer) VALUES " +
                "('What is the atomic number of carbon?', 'The atomic number of carbon is 6.'), " +
                "('What is the chemical symbol for gold?', 'The chemical symbol for gold is Au.'), " +
                "('What is the process by which plants make their own food using sunlight?', 'Photosynthesis.'), " +
                "('Who is credited with the discovery of penicillin?', 'Alexander Fleming.'), " +
                "('What is the largest organ in the human body?', 'The skin.'), " +
                "('What is the speed of light in a vacuum?', 'Approximately 299,792,458 meters per second.'), " +
                "('What is the chemical formula for water?', 'H₂O.'), " +
                "('What gas do plants absorb from the atmosphere and use during photosynthesis?', 'Carbon dioxide (CO₂).'), " +
                "('What is the Earth''s outermost layer called?', 'The crust.'), " +
                "('What is the chemical symbol for iron?', 'Fe.')");

        // Insert Social Science questions and answers
        db.execSQL("INSERT INTO " + TABLE_SOCIAL_SCIENCE + " (question, answer) VALUES " +
                "('What is the capital city of France?', 'Paris.'), " +
                "('Which river is the longest in the world?', 'The Nile River.'), " +
                "('Who was the first President of the United States?', 'George Washington.'), " +
                "('What is the political system in which power is vested in the people and exercised by elected representatives?', 'Democracy.'), " +
                "('In which year did Christopher Columbus first voyage to the Americas?', '1492.'), " +
                "('What is the tallest mountain in the world?', 'Mount Everest.'), " +
                "('Which planet is known as the ''Red Planet''?', 'Mars.'), " +
                "('Who is considered the ''Father of Modern Physics''?', 'Albert Einstein.'), " +
                "('What is the largest mammal in the world?', 'The blue whale.'), " +
                "('In which year did World War I begin?', '1914.')");

        // Insert General Knowledge questions and answers
        db.execSQL("INSERT INTO " + TABLE_GENERAL_KNOWLEDGE + " (question, answer) VALUES " +
                "('What is the currency of Japan?', 'Japanese Yen.'), " +
                "('Which planet is known as the ''Morning Star'' or ''Evening Star''?', 'Venus.'), " +
                "('Who painted the Mona Lisa?', 'Leonardo da Vinci.'), " +
                "('What is the national flower of India?', 'Lotus.'), " +
                "('Which gas do plants absorb from the atmosphere and release oxygen during photosynthesis?', 'Carbon dioxide (CO₂).'), " +
                "('Who is the author of the novel ''1984''?', 'George Orwell.'), " +
                "('What is the largest ocean on Earth?', 'Pacific Ocean.'), " +
                "('Who painted the ceiling of the Sistine Chapel?', 'Michelangelo.'), " +
                "('What is the chemical symbol for gold?', 'Au.'), " +
                "('In which year did the Titanic sink?', '1912.')");

        // Insert Computer Science questions and answers
        db.execSQL("INSERT INTO " + TABLE_COMPUTER_SCIENCE + " (question, answer) VALUES " +
                "('What does CPU stand for in computing?', 'Central Processing Unit.'), " +
                "('Which programming language is known as the ''mother of all languages''?', 'Assembly Language.'), " +
                "('What is the primary purpose of an operating system?', 'To manage hardware and provide services for computer programs.'), " +
                "('What does HTML stand for in web development?', 'Hypertext Markup Language.'), " +
                "('Which company developed the first graphical user interface (GUI) for personal computers?', 'Apple Inc.'), " +
                "('What is the function of RAM in a computer?', 'To provide quick access to data that the computer is currently using or processing.'), " +
                "('Which programming language is commonly used for developing Android apps?', 'Java.'), " +
                "('What does the acronym ''URL'' stand for in web addresses?', 'Uniform Resource Locator.'), " +
                "('What is the largest social media platform in terms of monthly active users?', 'Facebook.'), " +
                "('Who is often referred to as the ''father of the computer''?', 'Charles Babbage.')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database schema upgrades if needed
    }
}
