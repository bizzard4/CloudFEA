import sys

from cloudfea import uploader

def print_usage():
	print("cloudfea [upload|solve] [file]")

print("CloudFEA")

if (len(sys.argv) < 2):
	print_usage()
	exit(-1)

command = sys.argv[1]

if command=='upload': # Upload to S3
	file = sys.argv[2]
	uploader.upload(file)

elif command=='solve': # Solve an existing mesh
	problem = sys.argv[2]

