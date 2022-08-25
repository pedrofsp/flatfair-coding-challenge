from contextlib import nullcontext
from django.db import models
from uuid import uuid4

# Create your models here.

    
class Units(models.Model):
    id_units = models.UUIDField(primary_key=True, default=uuid4, editable=False)
    name = models.CharField(max_length=255)
    has_fixed_membership_fee = models.BooleanField(default=False)
    fixed_membership_fee_amount = models.IntegerField(default=0)

