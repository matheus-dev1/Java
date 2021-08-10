package com.amazonaws.samples;

import java.io.File;
import java.util.List;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public class S3Exemplo {

	public static void main(String[] args) {
		String acessKey = "AKIAWXZQLU5Q2SKBVHLK";
		String secretKey = "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";
		
		BasicAWSCredentials awsCredencials = new BasicAWSCredentials(acessKey, secretKey);
		// Builder
		AmazonS3 s3 = AmazonS3ClientBuilder.
			standard().
				withCredentials(
					new AWSStaticCredentialsProvider(awsCredencials)).
						withRegion(Regions.SA_EAST_1).
							build();
		
		// System.out.println("Criando Bucket...");
		String bucketName = "alura-s3-sdk-v001";
		// s3.createBucket(bucketName);
		
		System.out.println("Listando Bukcets...");
		List<Bucket> buckets = s3.listBuckets();
		
		for (Bucket bucket : buckets) {
			System.out.println(bucket);
		}
		
		// System.out.println("Enviando arquivo...");
		// File file1 = new File("amazon.jpg");
		// s3.putObject(bucketName, "amazon-s3-a1.jpg", file1);
		
		System.out.println("Listando objetos do Bucket");
		ObjectListing listObjects = s3.listObjects(new ListObjectsRequest().withBucketName(bucketName));
		for (S3ObjectSummary objectSummary : listObjects.getObjectSummaries()) {
			System.out.println("*" + objectSummary.getKey() + " - " + objectSummary.getSize());
		}
		
		// System.out.println("Deletando Objeto...");
		// s3.deleteObject(bucketName, "amazon-s3-a1.jpg");
		
		// System.out.println("Listando objetos do Bucket");
		// ObjectListing listObjects2 = s3.listObjects(new ListObjectsRequest().withBucketName(bucketName));
		// for (S3ObjectSummary objectSummary2 : listObjects2.getObjectSummaries()) {
			// System.out.println("*" + objectSummary2.getKey() + " - " + objectSummary2.getSize());
		// }
		
		s3.deleteBucket(bucketName);
	}

}
