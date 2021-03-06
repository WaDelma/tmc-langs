package fi.helsinki.cs.tmc.langs.utils;

import junit.framework.TestCase;

import org.apache.commons.io.FileUtils;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;

public class ProcessRunnerTest extends TestCase {

    private Path folder;

    @Override
    protected void setUp() throws Exception {
        this.folder = Files.createTempDirectory("process-runner");
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        FileUtils.deleteDirectory(this.folder.toFile());
        super.tearDown();
    }

    @Test
    public void testFailingProcessHasCorrectStatus() throws Exception {
        ProcessRunner runner = new ProcessRunner(new String[]{"java"}, this.folder);
        assertEquals(1, runner.call().statusCode);
    }

    @Test
    public void testProcessHasCorrectStatus() throws Exception {
        ProcessRunner runner = new ProcessRunner(new String[]{"java", "-version"}, this.folder);
        assertEquals(0, runner.call().statusCode);
    }

    @Test
    public void testProcessHasCorrectOutput() throws Exception {
        ProcessRunner runner = new ProcessRunner(
                new String[]{"git", "--help"},
                this.folder
        );
        String output = runner.call().output;
        assertTrue(output.contains("git"));
    }

    @Test
    public void testProcessHasCorrectErrorOutput() throws Exception {
        ProcessRunner runner = new ProcessRunner(new String[]{"java", "-version"}, this.folder);
        String error = runner.call().errorOutput;
        assertTrue(error.contains("version"));
    }
}
