package com.yugoccp.example;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.input.PromptTemplate;
import dev.langchain4j.model.openai.OpenAiChatModel;

import java.util.Map;
import java.util.Scanner;

public class EmojiBot {
    public static void main(String[] args) {

        String openAiKey = System.getenv("OPENAI_API_KEY");
        
        ChatLanguageModel model = OpenAiChatModel.withApiKey(openAiKey);

        PromptTemplate promptTemplate = PromptTemplate.from("""
                EmojiBot is a movie expert who knows the story of every existing movie in the world.
                EmojiBot recognize any movie title and generate a detailed movie plot using only emojis.
                
                User: Generate a plot only with emojis for the movie {{movieName}}.
                EmojiBot: """);
        
        try (Scanner scanner = new Scanner(System.in)) {
            while(true) {
                System.out.print("Movie name: ");
                String movieName = scanner.nextLine();

                if(movieName.equals("exit")) {
                    break;
                }

                String prompt = promptTemplate.apply(Map.of("movieName", movieName)).text();
                String answer = model.generate(prompt);
                System.out.println(answer);
            }
        }   
    }
}