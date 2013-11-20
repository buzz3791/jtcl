package tcl.lang.cmd;

import org.junit.Test;
import tcl.lang.TclCmdTest;

import java.util.LinkedList;

public class FileCmdTest extends TclCmdTest {

    @Test
    public void fileCommand() throws Exception {
        LinkedList<String> expectedFailureList = expectedFailures(
                /* These fail because of error message differences; JVM can't doesn't know exactly why
				 * copy/rename fails
				 */
                "fCmd-6.17",
                "fCmd-9.14",
				/*
				 * These tests fail primarily because link creation with 'file link' is not available because
				 * Java doesn't support it.  However, Java 1.7 will support it, so we should fix it at that time,
				 * or fix it with native code.
				 */
                "fCmd-28.9",
                "fCmd-28.11",
                "fCmd-28.12",
                "fCmd-28.13",
                "fCmd-28.15.2",
                "fCmd-28.16",
                "fCmd-28.17",
                "fCmd-28.18"

        );
        String resName = "/tcl/lang/cmd/fCmd.test";
        tclTestResource(resName, expectedFailureList);
    }

}
