Feature: Issuing Bus Passes

Scenario: 01 - Persons under the age of 16 should only be issued child bus passes
Given bus passes are issued to persons with the following details:
|Firstname |Lastname |Age  |
|Jeff      |Jones    |15   |
|Mary      |Cotten   |16   |
|Karen     |Smith    |14   |
When the bus passes are submitted
Then the child bus passes should be issued to the following persons:
|Firstname |Lastname |
|Jeff      |Jones    |
|Karen     |Smith    |

Scenario: 02 - Persons the age of 16 or older should only be issued adult bus passes
Given bus passes are issued to persons with the following details:
|Firstname |Lastname |Age  |
|Jeff      |Jones    |15   |
|Mary      |Cotten   |16   |
|James     |Jenkins  |29   |
When the bus passes are submitted
Then the adult bus passes should be issued to the following persons:
|Firstname |Lastname |
|Mary      |Cotten   |
|James     |Jenkins  |