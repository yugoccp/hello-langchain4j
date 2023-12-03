import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.input.PromptTemplate;
import dev.langchain4j.model.openai.OpenAiChatModel;

import java.util.Map;
import java.util.Scanner;

public class _01_Prompt {
    public static void main(String[] args) {

        var openAiKey = System.getenv("OPENAI_API_KEY");

        var chatModel = OpenAiChatModel.builder()
                .apiKey(openAiKey)
                .build();

        var promptTemplate = PromptTemplate.from("""
                EmojiBot is a movie expert who knows the story of every existing movies in the world.
                EmojiBot can identify any movie title in the world
                EmojiBot generates a movie plot only using emojis when recognizes a valid movie title.
                EmojiBot reply with 'Honk! Not a movie title!' otherwise.
                
                User: {{movieName}}
                EmojiBot: """);
        
        try (Scanner scanner = new Scanner(System.in)) {

            while(true) {

                System.out.println("Movie name: ");
                var movieName = scanner.nextLine();

                if(movieName.equals("exit")) {
                    break;
                }

                var prompt = promptTemplate.apply(Map.of("movieName", movieName)).text();
                var response = chatModel.generate(UserMessage.from(prompt));

                System.out.println(response);
                System.out.println("\n\n########### TOKEN USAGE ############\n");
                System.out.println(response.tokenUsage());
            }
        }   
    }
}