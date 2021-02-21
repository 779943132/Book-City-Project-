package com.book.test;

import com.book.utils.Jdbcs;
import org.junit.Test;

import static org.junit.Assert.*;

public class JdbcsTest {

    @Test
    public void getConnection() {
        System.out.println(Jdbcs.getConnection());
    }
}