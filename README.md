
To use it in your maven project, add the following repository to your `pom.xml`:

        <repositories>
            <repository>
                <id>deluan.repo</id>
                <name>Deluan's Projects Repository</name>
                <url>http://deluan.googlecode.com/svn/releases</url>
            </repository>
            <repository>
                <id>deluan.snapshots</id>
                <name>Deluan's Projects Snapshots Repository</name>
                <url>http://deluan.googlecode.com/svn/snapshots</url>
                <releases>
                    <enabled>false</enabled>
                </releases>
            </repository>
        </repositories>

And add the jar dependency:

        <dependency>
            <groupId>org.apache.shiro</groupId>
            <artifactId>shiro-faces</artifactId>
            <version>2.0-SNAPSHOT</version>
        </dependency>
