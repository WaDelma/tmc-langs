package fi.helsinki.cs.tmc.langs.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import fi.helsinki.cs.tmc.langs.domain.RunResult;
import fi.helsinki.cs.tmc.langs.domain.TestResult;
import fi.helsinki.cs.tmc.langs.utils.TestUtils;

import org.junit.Test;

import java.io.File;

public class TestResultParserTest {

    private TestResultParser parser = new TestResultParser();

    @Test
    public void testParseTestFile() {
        File resultsFile = TestUtils.getPath(this.getClass(), "results.txt").toFile();
        RunResult result = parser.parseTestResult(resultsFile);
        assertNotNull(result);

        for (TestResult testResult : result.testResults) {
            assertFieldsNotNull(testResult);
        }

        assertEquals("Result status should be PASSED", RunResult.Status.PASSED, result.status);
        assertEquals("Test name was wrong", "ArithTest testAdd", result.testResults.get(0).name);
    }

    @Test
    @SuppressWarnings("checkstyle:linelength")
    public void testParseTestJson() {
        String json =
                "[{\"className\":\"ArithTest\",\"methodName\":\"testAdd\",\"pointNames\":[\"arith-funcs\"],\"status\":\"PASSED\"},{\"className\":\"ArithTest\",\"methodName\":\"testSub\",\"pointNames\":[\"arith-funcs\"],\"message\":\"expected:\\u003c-1\\u003e but was:\\u003c0\\u003e\",\"exception\":{\"className\":\"java.lang.AssertionError\",\"message\":\"expected:\\u003c-1\\u003e but was:\\u003c0\\u003e\",\"stackTrace\":[{\"declaringClass\":\"org.junit.Assert\",\"methodName\":\"fail\",\"fileName\":\"Assert.java\",\"lineNumber\":88},{\"declaringClass\":\"org.junit.Assert\",\"methodName\":\"failNotEquals\",\"fileName\":\"Assert.java\",\"lineNumber\":743},{\"declaringClass\":\"org.junit.Assert\",\"methodName\":\"assertEquals\",\"fileName\":\"Assert.java\",\"lineNumber\":118},{\"declaringClass\":\"org.junit.Assert\",\"methodName\":\"assertEquals\",\"fileName\":\"Assert.java\",\"lineNumber\":555},{\"declaringClass\":\"org.junit.Assert\",\"methodName\":\"assertEquals\",\"fileName\":\"Assert.java\",\"lineNumber\":542},{\"declaringClass\":\"ArithTest\",\"methodName\":\"testSub\",\"fileName\":\"ArithTest.java\",\"lineNumber\":16},{\"declaringClass\":\"sun.reflect.NativeMethodAccessorImpl\",\"methodName\":\"invoke0\",\"fileName\":\"NativeMethodAccessorImpl.java\",\"lineNumber\":-2},{\"declaringClass\":\"sun.reflect.NativeMethodAccessorImpl\",\"methodName\":\"invoke\",\"fileName\":\"NativeMethodAccessorImpl.java\",\"lineNumber\":62},{\"declaringClass\":\"sun.reflect.DelegatingMethodAccessorImpl\",\"methodName\":\"invoke\",\"fileName\":\"DelegatingMethodAccessorImpl.java\",\"lineNumber\":43},{\"declaringClass\":\"java.lang.reflect.Method\",\"methodName\":\"invoke\",\"fileName\":\"Method.java\",\"lineNumber\":483},{\"declaringClass\":\"org.junit.runners.model.FrameworkMethod$1\",\"methodName\":\"runReflectiveCall\",\"fileName\":\"FrameworkMethod.java\",\"lineNumber\":47},{\"declaringClass\":\"org.junit.internal.runners.model.ReflectiveCallable\",\"methodName\":\"run\",\"fileName\":\"ReflectiveCallable.java\",\"lineNumber\":12},{\"declaringClass\":\"org.junit.runners.model.FrameworkMethod\",\"methodName\":\"invokeExplosively\",\"fileName\":\"FrameworkMethod.java\",\"lineNumber\":44},{\"declaringClass\":\"org.junit.internal.runners.statements.InvokeMethod\",\"methodName\":\"evaluate\",\"fileName\":\"InvokeMethod.java\",\"lineNumber\":17},{\"declaringClass\":\"org.junit.runners.ParentRunner\",\"methodName\":\"runLeaf\",\"fileName\":\"ParentRunner.java\",\"lineNumber\":271},{\"declaringClass\":\"org.junit.runners.BlockJUnit4ClassRunner\",\"methodName\":\"runChild\",\"fileName\":\"BlockJUnit4ClassRunner.java\",\"lineNumber\":70},{\"declaringClass\":\"org.junit.runners.BlockJUnit4ClassRunner\",\"methodName\":\"runChild\",\"fileName\":\"BlockJUnit4ClassRunner.java\",\"lineNumber\":50},{\"declaringClass\":\"org.junit.runners.ParentRunner$3\",\"methodName\":\"run\",\"fileName\":\"ParentRunner.java\",\"lineNumber\":238},{\"declaringClass\":\"org.junit.runners.ParentRunner$1\",\"methodName\":\"schedule\",\"fileName\":\"ParentRunner.java\",\"lineNumber\":63},{\"declaringClass\":\"org.junit.runners.ParentRunner\",\"methodName\":\"runChildren\",\"fileName\":\"ParentRunner.java\",\"lineNumber\":236},{\"declaringClass\":\"org.junit.runners.ParentRunner\",\"methodName\":\"access$000\",\"fileName\":\"ParentRunner.java\",\"lineNumber\":53},{\"declaringClass\":\"org.junit.runners.ParentRunner$2\",\"methodName\":\"evaluate\",\"fileName\":\"ParentRunner.java\",\"lineNumber\":229},{\"declaringClass\":\"org.junit.runners.ParentRunner\",\"methodName\":\"run\",\"fileName\":\"ParentRunner.java\",\"lineNumber\":309},{\"declaringClass\":\"fi.helsinki.cs.tmc.testrunner.TestRunner$TestingRunnable\",\"methodName\":\"runTestCase\",\"fileName\":\"TestRunner.java\",\"lineNumber\":134},{\"declaringClass\":\"fi.helsinki.cs.tmc.testrunner.TestRunner$TestingRunnable\",\"methodName\":\"doRun\",\"fileName\":\"TestRunner.java\",\"lineNumber\":89},{\"declaringClass\":\"fi.helsinki.cs.tmc.testrunner.TestRunner$TestingRunnable\",\"methodName\":\"run\",\"fileName\":\"TestRunner.java\",\"lineNumber\":70},{\"declaringClass\":\"java.lang.Thread\",\"methodName\":\"run\",\"fileName\":\"Thread.java\",\"lineNumber\":745}]},\"status\":\"FAILED\"},{\"className\":\"ArithTest\",\"methodName\":\"testMul\",\"pointNames\":[\"arith-funcs\"],\"message\":\"expected:\\u003c12\\u003e but was:\\u003c0\\u003e\",\"exception\":{\"className\":\"java.lang.AssertionError\",\"message\":\"expected:\\u003c12\\u003e but was:\\u003c0\\u003e\",\"stackTrace\":[{\"declaringClass\":\"org.junit.Assert\",\"methodName\":\"fail\",\"fileName\":\"Assert.java\",\"lineNumber\":88},{\"declaringClass\":\"org.junit.Assert\",\"methodName\":\"failNotEquals\",\"fileName\":\"Assert.java\",\"lineNumber\":743},{\"declaringClass\":\"org.junit.Assert\",\"methodName\":\"assertEquals\",\"fileName\":\"Assert.java\",\"lineNumber\":118},{\"declaringClass\":\"org.junit.Assert\",\"methodName\":\"assertEquals\",\"fileName\":\"Assert.java\",\"lineNumber\":555},{\"declaringClass\":\"org.junit.Assert\",\"methodName\":\"assertEquals\",\"fileName\":\"Assert.java\",\"lineNumber\":542},{\"declaringClass\":\"ArithTest\",\"methodName\":\"testMul\",\"fileName\":\"ArithTest.java\",\"lineNumber\":22},{\"declaringClass\":\"sun.reflect.NativeMethodAccessorImpl\",\"methodName\":\"invoke0\",\"fileName\":\"NativeMethodAccessorImpl.java\",\"lineNumber\":-2},{\"declaringClass\":\"sun.reflect.NativeMethodAccessorImpl\",\"methodName\":\"invoke\",\"fileName\":\"NativeMethodAccessorImpl.java\",\"lineNumber\":62},{\"declaringClass\":\"sun.reflect.DelegatingMethodAccessorImpl\",\"methodName\":\"invoke\",\"fileName\":\"DelegatingMethodAccessorImpl.java\",\"lineNumber\":43},{\"declaringClass\":\"java.lang.reflect.Method\",\"methodName\":\"invoke\",\"fileName\":\"Method.java\",\"lineNumber\":483},{\"declaringClass\":\"org.junit.runners.model.FrameworkMethod$1\",\"methodName\":\"runReflectiveCall\",\"fileName\":\"FrameworkMethod.java\",\"lineNumber\":47},{\"declaringClass\":\"org.junit.internal.runners.model.ReflectiveCallable\",\"methodName\":\"run\",\"fileName\":\"ReflectiveCallable.java\",\"lineNumber\":12},{\"declaringClass\":\"org.junit.runners.model.FrameworkMethod\",\"methodName\":\"invokeExplosively\",\"fileName\":\"FrameworkMethod.java\",\"lineNumber\":44},{\"declaringClass\":\"org.junit.internal.runners.statements.InvokeMethod\",\"methodName\":\"evaluate\",\"fileName\":\"InvokeMethod.java\",\"lineNumber\":17},{\"declaringClass\":\"org.junit.runners.ParentRunner\",\"methodName\":\"runLeaf\",\"fileName\":\"ParentRunner.java\",\"lineNumber\":271},{\"declaringClass\":\"org.junit.runners.BlockJUnit4ClassRunner\",\"methodName\":\"runChild\",\"fileName\":\"BlockJUnit4ClassRunner.java\",\"lineNumber\":70},{\"declaringClass\":\"org.junit.runners.BlockJUnit4ClassRunner\",\"methodName\":\"runChild\",\"fileName\":\"BlockJUnit4ClassRunner.java\",\"lineNumber\":50},{\"declaringClass\":\"org.junit.runners.ParentRunner$3\",\"methodName\":\"run\",\"fileName\":\"ParentRunner.java\",\"lineNumber\":238},{\"declaringClass\":\"org.junit.runners.ParentRunner$1\",\"methodName\":\"schedule\",\"fileName\":\"ParentRunner.java\",\"lineNumber\":63},{\"declaringClass\":\"org.junit.runners.ParentRunner\",\"methodName\":\"runChildren\",\"fileName\":\"ParentRunner.java\",\"lineNumber\":236},{\"declaringClass\":\"org.junit.runners.ParentRunner\",\"methodName\":\"access$000\",\"fileName\":\"ParentRunner.java\",\"lineNumber\":53},{\"declaringClass\":\"org.junit.runners.ParentRunner$2\",\"methodName\":\"evaluate\",\"fileName\":\"ParentRunner.java\",\"lineNumber\":229},{\"declaringClass\":\"org.junit.runners.ParentRunner\",\"methodName\":\"run\",\"fileName\":\"ParentRunner.java\",\"lineNumber\":309},{\"declaringClass\":\"fi.helsinki.cs.tmc.testrunner.TestRunner$TestingRunnable\",\"methodName\":\"runTestCase\",\"fileName\":\"TestRunner.java\",\"lineNumber\":134},{\"declaringClass\":\"fi.helsinki.cs.tmc.testrunner.TestRunner$TestingRunnable\",\"methodName\":\"doRun\",\"fileName\":\"TestRunner.java\",\"lineNumber\":89},{\"declaringClass\":\"fi.helsinki.cs.tmc.testrunner.TestRunner$TestingRunnable\",\"methodName\":\"run\",\"fileName\":\"TestRunner.java\",\"lineNumber\":70},{\"declaringClass\":\"java.lang.Thread\",\"methodName\":\"run\",\"fileName\":\"Thread.java\",\"lineNumber\":745}]},\"status\":\"FAILED\"},{\"className\":\"ArithTest\",\"methodName\":\"testDiv\",\"pointNames\":[\"arith-funcs\"],\"message\":\"expected:\\u003c3\\u003e but was:\\u003c0\\u003e\",\"exception\":{\"className\":\"java.lang.AssertionError\",\"message\":\"expected:\\u003c3\\u003e but was:\\u003c0\\u003e\",\"stackTrace\":[{\"declaringClass\":\"org.junit.Assert\",\"methodName\":\"fail\",\"fileName\":\"Assert.java\",\"lineNumber\":88},{\"declaringClass\":\"org.junit.Assert\",\"methodName\":\"failNotEquals\",\"fileName\":\"Assert.java\",\"lineNumber\":743},{\"declaringClass\":\"org.junit.Assert\",\"methodName\":\"assertEquals\",\"fileName\":\"Assert.java\",\"lineNumber\":118},{\"declaringClass\":\"org.junit.Assert\",\"methodName\":\"assertEquals\",\"fileName\":\"Assert.java\",\"lineNumber\":555},{\"declaringClass\":\"org.junit.Assert\",\"methodName\":\"assertEquals\",\"fileName\":\"Assert.java\",\"lineNumber\":542},{\"declaringClass\":\"ArithTest\",\"methodName\":\"testDiv\",\"fileName\":\"ArithTest.java\",\"lineNumber\":29},{\"declaringClass\":\"sun.reflect.NativeMethodAccessorImpl\",\"methodName\":\"invoke0\",\"fileName\":\"NativeMethodAccessorImpl.java\",\"lineNumber\":-2},{\"declaringClass\":\"sun.reflect.NativeMethodAccessorImpl\",\"methodName\":\"invoke\",\"fileName\":\"NativeMethodAccessorImpl.java\",\"lineNumber\":62},{\"declaringClass\":\"sun.reflect.DelegatingMethodAccessorImpl\",\"methodName\":\"invoke\",\"fileName\":\"DelegatingMethodAccessorImpl.java\",\"lineNumber\":43},{\"declaringClass\":\"java.lang.reflect.Method\",\"methodName\":\"invoke\",\"fileName\":\"Method.java\",\"lineNumber\":483},{\"declaringClass\":\"org.junit.runners.model.FrameworkMethod$1\",\"methodName\":\"runReflectiveCall\",\"fileName\":\"FrameworkMethod.java\",\"lineNumber\":47},{\"declaringClass\":\"org.junit.internal.runners.model.ReflectiveCallable\",\"methodName\":\"run\",\"fileName\":\"ReflectiveCallable.java\",\"lineNumber\":12},{\"declaringClass\":\"org.junit.runners.model.FrameworkMethod\",\"methodName\":\"invokeExplosively\",\"fileName\":\"FrameworkMethod.java\",\"lineNumber\":44},{\"declaringClass\":\"org.junit.internal.runners.statements.InvokeMethod\",\"methodName\":\"evaluate\",\"fileName\":\"InvokeMethod.java\",\"lineNumber\":17},{\"declaringClass\":\"org.junit.runners.ParentRunner\",\"methodName\":\"runLeaf\",\"fileName\":\"ParentRunner.java\",\"lineNumber\":271},{\"declaringClass\":\"org.junit.runners.BlockJUnit4ClassRunner\",\"methodName\":\"runChild\",\"fileName\":\"BlockJUnit4ClassRunner.java\",\"lineNumber\":70},{\"declaringClass\":\"org.junit.runners.BlockJUnit4ClassRunner\",\"methodName\":\"runChild\",\"fileName\":\"BlockJUnit4ClassRunner.java\",\"lineNumber\":50},{\"declaringClass\":\"org.junit.runners.ParentRunner$3\",\"methodName\":\"run\",\"fileName\":\"ParentRunner.java\",\"lineNumber\":238},{\"declaringClass\":\"org.junit.runners.ParentRunner$1\",\"methodName\":\"schedule\",\"fileName\":\"ParentRunner.java\",\"lineNumber\":63},{\"declaringClass\":\"org.junit.runners.ParentRunner\",\"methodName\":\"runChildren\",\"fileName\":\"ParentRunner.java\",\"lineNumber\":236},{\"declaringClass\":\"org.junit.runners.ParentRunner\",\"methodName\":\"access$000\",\"fileName\":\"ParentRunner.java\",\"lineNumber\":53},{\"declaringClass\":\"org.junit.runners.ParentRunner$2\",\"methodName\":\"evaluate\",\"fileName\":\"ParentRunner.java\",\"lineNumber\":229},{\"declaringClass\":\"org.junit.runners.ParentRunner\",\"methodName\":\"run\",\"fileName\":\"ParentRunner.java\",\"lineNumber\":309},{\"declaringClass\":\"fi.helsinki.cs.tmc.testrunner.TestRunner$TestingRunnable\",\"methodName\":\"runTestCase\",\"fileName\":\"TestRunner.java\",\"lineNumber\":134},{\"declaringClass\":\"fi.helsinki.cs.tmc.testrunner.TestRunner$TestingRunnable\",\"methodName\":\"doRun\",\"fileName\":\"TestRunner.java\",\"lineNumber\":89},{\"declaringClass\":\"fi.helsinki.cs.tmc.testrunner.TestRunner$TestingRunnable\",\"methodName\":\"run\",\"fileName\":\"TestRunner.java\",\"lineNumber\":70},{\"declaringClass\":\"java.lang.Thread\",\"methodName\":\"run\",\"fileName\":\"Thread.java\",\"lineNumber\":745}]},\"status\":\"FAILED\"}]";
        RunResult result = parser.parseTestResult(json);
        assertNotNull(result);

        for (TestResult testResult : result.testResults) {
            assertFieldsNotNull(testResult);
        }

        assertEquals("There should be 4 test results in the result", 4, result.testResults.size());

        TestResult testResult = result.testResults.get(0);
        assertEquals("ArithTest testAdd", testResult.name);
        assertTrue("ArithTest testAdd passed should be true", testResult.passed);
    }

    private void assertFieldsNotNull(TestResult testResult) {
        assertNotNull(testResult.errorMessage);
        assertNotNull(testResult.backtrace);
        assertNotNull(testResult.name);
        assertNotNull(testResult.passed);
        assertNotNull(testResult.points);
    }
}