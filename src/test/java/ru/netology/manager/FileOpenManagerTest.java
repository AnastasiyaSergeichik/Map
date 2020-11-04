package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class FileOpenManagerTest {
    private FileOpenManager fileOpenManager = new FileOpenManager();


    private String office = "Word";
    private String browser = "Google Chrome";
    private String image = "Adobe Photoshop";


    private String doc = ".doc";
    private String html = ".html";
    private String png = ".png";
    private String jpg = ".jpg";


    @BeforeEach
    void setUp() {
        fileOpenManager.register(doc,office );
        fileOpenManager.register(html, browser);
        fileOpenManager.remove(".jpg");
        fileOpenManager.register(png, image);
        fileOpenManager.register(jpg, image);
    }

    @Test
    void shouldGetAllApps() {
        Set<String> actual = fileOpenManager.getAllApps();
        Set<String> expected = new HashSet<>();
          expected.add(image);
        expected.add(browser);
        expected.add(office);
        assertEquals(expected, actual);
    }


    @Test
    void shouldGetAllExtension() {
        Collection<String> actual = fileOpenManager.getAllExtension();
        List<String> expected = Arrays.asList(doc, html, jpg, png);
        assertEquals(expected, actual);
    }


    @Test
    void shouldGetNameByType() {
        String expected = "Adobe Photoshop";
        String actual = fileOpenManager.getName(".jpg");
        assertEquals(expected, actual);
    }


    @Test
    void shouldShowNameByTypeUsedUppercase() {
        String expected = "Adobe Photoshop";
        String actual = fileOpenManager.getName(".JPG");
        assertEquals(expected, actual);
    }


    @Test
    void shouldNotGetNameByType() {
        String actual = fileOpenManager.getName(".jpeg");
        assertNull(actual);
    }


    @Test
    void shouldRemove() {
        String actual = fileOpenManager.remove("Word");
        assertNull(actual);
    }
}

