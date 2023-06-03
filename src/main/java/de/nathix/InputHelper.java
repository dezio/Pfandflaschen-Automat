package de.nathix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputHelper {

    public static String ask(String question) {
        System.out.print(question + ":> ");
        String answer = "";

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            answer = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return answer;
    }

    public static int askForInt(String question) {
        String answer = ask(question);

        try {
            return Integer.parseInt(answer);
        }
        catch(NumberFormatException ex) {
            System.out.println("Du dödel hast keinen Integer angegeben.");
            return askForInt(question);
        }
    }

    /**
     * Asks the user for a specific list of options.
     * Lets the user retry when the option was not correct.
     *
     * @param question The question
     * @param options The possible options the user can choose from
     * @return The selected option from the user
     */
    public static String askForOption(String question, String[] options) {
        // Optionen zu einem String zusammenbasteln
        String strOptions = "";
        for(int i = 0; i < options.length; i++) {
            strOptions += options[i] + ", ";
        }

        String answer = ask(question + "(" + strOptions + ")");

        boolean isOptionOk = false;
        for(int i = 0; i < options.length; i++) {
            if (answer.equals(options[i])) {
                isOptionOk = true;
                break;
            }
        }

        if(!isOptionOk) {
            System.out.println("Du Penner hast die Optionen wohl nicht gecheckt!");
            for(int i = 0; i < options.length; i++) {
                System.out.println("> " + options[i]);
            } // if end

            System.out.println("Try again!");

            return askForOption(question, options);
        } // if end

        return answer;
    }
}
