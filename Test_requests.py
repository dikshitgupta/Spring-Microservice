import os
import requests
from faker import Faker
import time

fake = Faker()

url="http://localhost:9191/departments/"

start_time = time.time()

for i in range(100):
    fake=Faker()
    department_name=fake.name()
    departmentAddress=fake.address()
    departmentCode=department_name[0:2]
    department_data={
    "departmentName":department_name,
    "departmentAddress":departmentAddress,
    "departmentCode":departmentCode
    }

    response=requests.post(url,json=department_data)
    print("{} at {}".format(response.status_code, (time.time()-start_time) ))
