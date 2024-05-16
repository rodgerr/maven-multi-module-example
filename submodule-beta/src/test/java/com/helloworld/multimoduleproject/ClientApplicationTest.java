package com.helloworld.multimoduleproject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientApplicationTest {

    @Test
    void main() {
        ClientApplication.main(new String[]{"arg1", "arg2"});
    }
}