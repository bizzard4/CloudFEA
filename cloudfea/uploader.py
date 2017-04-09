import boto3
from pathlib import Path
import os

def upload(mesh_file):
	print("Uploading", mesh_file, "to S3")

	file = Path(mesh_file)
	if not file.is_file():
		print("Bad mesh file path")
		return

	# TODO : Duplicate name
	# TODO : Compare checksum before uploading
	# NICE-TO-HAVE : Validate mesh

	s3 = boto3.resource('s3')
	data = file.open('rb')
	s3.Bucket('cloudfea').put_object(Key=os.path.basename(mesh_file), Body=data)





