package org.com.nubes.security.aes;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.CompressionOutputStream;
import org.apache.hadoop.util.ReflectionUtils;

public class Encrypt {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
    	
        
        Configuration conf = new Configuration();
        
		FileSystem hdfs = FileSystem.get(conf);
		
        InputStream in = new BufferedInputStream(new FileInputStream("C:\\Users\\aruna_chinnaswami\\Desktop\\HD\\windoop\\eclipse\\workspace\\Security\\input\\Taichung.txt"));
        
        Class<?> codecClass = Class.forName("org.com.nubes.security.aes.AesParallelCryptoCodec");
        CompressionCodec codec = (CompressionCodec)ReflectionUtils.newInstance(codecClass, conf);


        OutputStream out = new FileOutputStream(new File("C:\\Users\\aruna_chinnaswami\\Desktop\\HD\\windoop\\eclipse\\workspace\\Security\\output\\encrypt.txt"));
        CompressionOutputStream cout = codec.createOutputStream(out);

        IOUtils.copyBytes(in,  cout,  1048576, true);

        cout.flush();
        //cout.close();
        in.close();
        out.close();
        hdfs.close();
    }
}
