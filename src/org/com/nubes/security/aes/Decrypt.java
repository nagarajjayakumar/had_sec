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
import org.apache.hadoop.io.compress.CompressionInputStream;
import org.apache.hadoop.util.ReflectionUtils;

public class Decrypt {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //if(args.length != 2) return;

    	System.out.println("Stsasrting dec");
     
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(conf);
        
        
        InputStream in =new FileInputStream("C:\\Users\\aruna_chinnaswami\\Desktop\\HD\\windoop\\eclipse\\workspace\\Security\\output\\encrypt.txt");
        
        Class<?> codecClass = Class.forName("org.com.nubes.security.aes.AesParallelCryptoCodec");
        CompressionCodec codec = (CompressionCodec)ReflectionUtils.newInstance(codecClass, conf);


        OutputStream out = new FileOutputStream(new File("C:\\Users\\aruna_chinnaswami\\Desktop\\HD\\windoop\\eclipse\\workspace\\Security\\output\\decrypt_1.txt"));

        CompressionInputStream cin = codec.createInputStream(in);

        IOUtils.copyBytes(cin,  out,  1048576*3, true);

        cin.close();
        in.close();
        out.close();
         fs.close();
    }
}
