package com.blu.imdg;

import java.util.Arrays;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.IgniteException;
import org.apache.ignite.Ignition;
import org.apache.ignite.cluster.ClusterState;
import org.apache.ignite.configuration.DataStorageConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder;

/**
 * Hello world!
 *
 */
public class HelloWorld {
    public static void main(String[] args) throws IgniteException {
    	 System.out.println("Hello Ignite");
         // create a new instance of TCP Discovery SPI
         TcpDiscoverySpi spi = new TcpDiscoverySpi();
         // create a new instance of tcp discovery multicast ip finder
         
         
         TcpDiscoveryMulticastIpFinder tcMp = new TcpDiscoveryMulticastIpFinder();
         tcMp.setAddresses(Arrays.asList("localhost")); // change your IP address here
         // set the multi cast ip finder for spi
         spi.setIpFinder(tcMp);
         // create new ignite configuration
         IgniteConfiguration cfg = new IgniteConfiguration();
         System.out.println("+++++++++++++++++"+cfg.getWorkDirectory());
         cfg.setClientMode(true);
         // set the discovery§ spi to ignite configuration
         cfg.setDiscoverySpi(spi);
         cfg.setPeerClassLoadingEnabled(false);
         // Start ignite
         
         //data storage configuration
         DataStorageConfiguration storageCfg = new DataStorageConfiguration();
         storageCfg.getDefaultDataRegionConfiguration().setPersistenceEnabled(true	);
         storageCfg.setStoragePath("C://apache-ignite-2.11.0-bin/opt/storage");
//         storageCfg.setWalPath("C://apache-ignite-2.11.0-bin/opt/storage");
//         storageCfg.setWalArchivePath("C://apache-ignite-2.11.0-bin/opt/storage");
//         storageCfg.setWalSegmentSize(128 * 1024 * 1024);
         cfg.setDataStorageConfiguration(storageCfg);
         
         
         Ignite ignite = Ignition.start(cfg);
         ignite.cluster().baselineAutoAdjustEnabled(false);
         //ignite.active(true);
         ignite.cluster().state(ClusterState.ACTIVE);
         
        
   
      // get or create cache
         IgniteCache<Integer, String> cache = ignite.getOrCreateCache("testCache");
        
         
         // put some cache elements
//         for (int i = 1; i <= 100; i++) {
//             cache.put(i, Integer.toString(i));
//         }
         
         // get them from the cache and write to the console
         ignite.cluster().enableWal("testCache");
         for (int i = 1; i <= 100; i++) {
             System.out.println("Cache get:" + cache.get(i));
         }
         ignite.close();
    }

   
}