package com.forceassociates.onpay_webtester;

import static java.util.Arrays.asList;
import java.util.List;

import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.spring.UsingSpring;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Use this class to configure story execution from the command line or within
 * Eclipse. From the command line use a maven goal of integration-test higher.
 * <p/>
 * <code>
 * >$ mvn integration-test
 * </code>
 * 
 * <p>
 * From with Eclipse, use the same m2e goal or execute this class a JUnit4
 * test. An initial m2e run might be required to copy all of the resources over
 * to the target/classes based destinations.
 * </p>
 * 
 * <p>
 * Both annotations and Spring context files hold the configuration jbehave as
 * describe below.
 * </p>
 * <table title="Annotation Descriptions" border="1">
 * <tr>
 * <th>Annotation</th>
 * <th>Purpose</th>
 * </tr>
 * <tr>
 * <td>@UsingSpring</td>
 * <td>Tells jbehave where to find Spring context files.</td>
 * <tr>
 * <td>@Configure</td>
 * <td>Tells jbehave configuration is described as annotation parameters or in a
 * Spring context file.</td>
 * <tr>
 * <td>@Embedder</td>
 * <td>Configures the embedder class used by jUnit invocations. The pom.xml
 * declares the embedder for maven invocations.</td>
 * </table>
 * <p>Spring Context File Descriptions</p>
 * <table border="1">
 * <tr>
 * <th>File</th>
 * <th>Purpose</th>
 * </tr>
 * <tr>
 * <td>configuration.xml</td>
 * <td>Parameters for the jbehave Configuration object.</td>
 * <tr>
 * <td>my_steps.xml</td>
 * <td>Which Step classes to use.</td>
 * </table>
 * 
 * @author Gordon Force Jr. (gordon@force-associates.com)
 * 
 */

// Instructs jbehave to build configurations from spring context files and to
// execute stories using a jUnit test runner
@RunWith(org.jbehave.core.junit.spring.SpringAnnotatedEmbedderRunner.class)

@UsingEmbedder(embedder = Embedder.class, generateViewAfterStories = true, ignoreFailureInStories = true, ignoreFailureInView = true)

//Empty inferes configuration exists either as defaults or within
//Spring context files.
@Configure()

// tells jbehave which spring context files hold configuration and step class
// declarations
@UsingSpring(resources = {
		"com/forceassociates/onpay_webtester/configuration.xml",
		"com/forceassociates/onpay_webtester/my_steps.xml" })

public class SpringAnnotatedStories extends InjectableEmbedder {

	private Logger logger = LoggerFactory
			.getLogger(SpringAnnotatedStories.class);

	@Test 
	@Override
	public void run() throws Throwable {

		List<String> paths = new StoryFinder().findPaths(CodeLocations
				.codeLocationFromClass(this.getClass()).getFile(),
				asList("**/*story.txt"), null);
		logger.info("found these stories to run {}", paths);
		injectedEmbedder().runStoriesAsPaths(paths);
	}

}
