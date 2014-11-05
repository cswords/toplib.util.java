/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package demo.soap.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.soap.DbServices;
import demo.orm.entity.*;

public final class Client {

	private Client() {
	}

	public static void main(String args[]) throws Exception {
		// START SNIPPET: client
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "client-beans.xml" });

		DbServices client = (DbServices) context.getBean("client");

		ResponseContainer response = client.list(9);
		// ResponseContainer response = client.holy("Shit");
		if (response.getText() != null) {
			System.out.println("Response: " + response.getText());
		} else if (response.getList() != null) {
			System.out.println("Response: "
					+ Integer.toString(response.getList().size()));
		} else {
			System.out.println("Response: empty");
		}

		context.close();
		System.exit(0);
		// END SNIPPET: client
	}
}
