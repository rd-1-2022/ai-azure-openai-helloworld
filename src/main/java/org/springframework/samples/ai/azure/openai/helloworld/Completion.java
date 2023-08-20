package org.springframework.samples.ai.azure.openai.helloworld;

public class Completion {

    private final String completion;

    public Completion(String completion) {
        this.completion = completion;
    }

    public String getCompletion() {
        return completion;
    }
}
