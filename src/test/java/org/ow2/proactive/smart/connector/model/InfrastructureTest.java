package org.ow2.proactive.smart.connector.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.Set;

import org.junit.Test;

import jersey.repackaged.com.google.common.collect.Sets;

public class InfrastructureTest {
	@Test
	public void testEmptyConstructor() {
		Infrastructure infrastructure = new Infrastructure();
		assertThat(infrastructure.getName(), is(nullValue()));
	}

	@Test
	public void testConstructor() {
		Infrastructure infrastructure = new Infrastructure("openstack", "openstackEndpoint", "openstackUserName",
				"openstackCredential");
		assertThat(infrastructure.getName(), is("openstack"));
	}

	@Test
	public void testEqualsAndHashcode() {
		Infrastructure infrastructure1 = new Infrastructure("openstack", "openstackEndpoint", "openstackUserName",
				"openstackCredential1");
		Infrastructure infrastructure2 = new Infrastructure("openstack", "openstackEndpoint", "openstackUserName",
				"openstackCredential2");

		Set<Infrastructure> infrastructures = Sets.newHashSet(infrastructure1, infrastructure2);

		assertThat(infrastructures.size(), is(1));
		assertThat(infrastructure1.equals(infrastructure2), is(true));
	}

}
