
To use it in your maven project, add the following repository to your `pom.xml`:

        <repositories>
                <repository>
                    <snapshots>
                        <enabled>false</enabled>
                    </snapshots>
                    <id>bintray-deluan-maven</id>
                    <name>bintray</name>
                    <url>http://dl.bintray.com/deluan/maven</url>
                </repository>
        </repositories>

And add the jar dependency:

        <dependency>
            <groupId>org.apache.shiro</groupId>
            <artifactId>shiro-faces</artifactId>
            <version>2.0</version>
        </dependency>
