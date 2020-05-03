package com.starter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileRead implements Runnable
{

private FileChannel _channel;
private long _startLocation;
private int _size;
int _sequence_number;

public FileRead(long loc, int size, FileChannel chnl, int sequence)
{
    _startLocation = loc;
    _size = size;
    _channel = chnl;
    _sequence_number = sequence;
}

@Override
public void run()
{
        System.out.println("Reading the channel: " + _startLocation + ":" + _size);

        //allocate memory
        ByteBuffer buff = ByteBuffer.allocate(_size);

        //Read file chunk to RAM
        try {
			_channel.read(buff, _startLocation);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      //chunk to String
        String string_chunk = new String(buff.array(), Charset.forName("UTF-8"));
        
        FileWriter st;
		try {
			st = new FileWriter("C:\\Users\\khank\\Desktop\\test.txt");
			 st.write(string_chunk);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       

        System.out.println("Done Reading the channel: " + _startLocation + ":" + _size);

}

//args[0] is path to read file
//args[1] is the size of thread pool; Need to try different values to fing sweet spot

//  C:\Users\khank\Desktop\java question
public static void main(String[] args) throws Exception
{
    FileInputStream fileInputStream = new FileInputStream(args[0]);
    FileChannel channel = fileInputStream.getChannel();
    
    long remaining_size = channel.size(); //get the total number of bytes in the file
    long chunk_size = remaining_size / Integer.parseInt(args[1]); //file_size/threads
    ExecutorService executor = Executors.newFixedThreadPool(Integer.parseInt(args[1]));

    long start_loc = 0;//file pointer
    int i = 0; //loop counter
    while (remaining_size >= chunk_size)
    {
        //launches a new thread
        executor.execute(new FileRead(start_loc, Math.toIntExact(chunk_size), channel, i));
        remaining_size = remaining_size - chunk_size;
        start_loc = start_loc + chunk_size;
        i++;
    }

    //load the last remaining piece
    executor.execute(new FileRead(start_loc, Math.toIntExact(remaining_size), channel, i));

    //Tear Down

}

}
