package com.yugoccp.example;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;

public class HelloBot {

    public static void main(String[] args) {

        String openAiKey = System.getenv("OPENAI_API_KEY");

        ChatLanguageModel model = OpenAiChatModel.withApiKey(openAiKey);

        String answer = model.generate("Write hello world in Java");

        System.out.println(answer);
    }
}