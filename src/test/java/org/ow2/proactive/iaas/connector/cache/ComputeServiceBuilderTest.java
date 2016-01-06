package org.ow2.proactive.iaas.connector.cache;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.jclouds.aws.ec2.compute.AWSEC2ComputeService;
import org.jclouds.compute.ComputeService;
import org.junit.Before;
import org.junit.Test;
import org.ow2.proactive.iaas.connector.cloud.provider.jcloud.JCloudComputeServiceBuilder;
import org.ow2.proactive.iaas.connector.fixtures.InfrastructureFixture;

public class ComputeServiceBuilderTest {

	private JCloudComputeServiceBuilder computeServiceBuilder;

	@Before
	public void init() {
		this.computeServiceBuilder = new JCloudComputeServiceBuilder();
	}

	@Test
	public void testBuildComputeServiceFromInfrastructureAWS() {
		ComputeService computerService = computeServiceBuilder.buildComputeServiceFromInfrastructure(
				InfrastructureFixture.getInfrastructure("id-aws-ec2", "aws-ec2", "", "userName", "credential"));

		assertThat(computerService, is(instanceOf(AWSEC2ComputeService.class)));
	}
	
	@Test
	public void testBuildComputeServiceFromInfrastructureAWSNullEndPoint() {
		ComputeService computerService = computeServiceBuilder.buildComputeServiceFromInfrastructure(
				InfrastructureFixture.getInfrastructure("id-aws-ec2","aws-ec2", null, "userName", "credential"));

		assertThat(computerService, is(instanceOf(AWSEC2ComputeService.class)));
	}

	@Test
	public void testBuildComputeServiceFromInfrastructureOpenstack() {
		ComputeService computerService = computeServiceBuilder.buildComputeServiceFromInfrastructure(
				InfrastructureFixture.getInfrastructure("id-openstack-nova","openstack-nova", "endPoint", "userName", "credential"));

		assertThat(computerService, is(not(instanceOf(AWSEC2ComputeService.class))));
	}

}
