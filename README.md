# Ignite-persistent-cache-example
Example project how values persist in ingnite cache and stored on disk and persist even after node restart



add below peroperty to enable persistance in example-ignite.xml

 <bean id="ignite.cfg" class="org.apache.ignite.configuration.IgniteConfiguration">
        <!-- Enabling Apache Ignite Persistent Store. -->
        <property name="dataStorageConfiguration">
            <bean class="org.apache.ignite.configuration.DataStorageConfiguration">
                <property name="defaultDataRegionConfiguration">
                    <bean class="org.apache.ignite.configuration.DataRegionConfiguration">
                        <property name="persistenceEnabled" value="true"/>
                    </bean>
                </property>
            </bean>
        </property>
	</bean>


1. after that run ignite node
2. run eclipse project 
3. verify cache data stored inside work/db/<some folder name>/cache-testCache
4. comment put data code in eclipse
5. restart ignite node and run again eclipse project.
6. verify if it still able to fetch data from persistane file storage and display on console.
