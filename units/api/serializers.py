from rest_framework import serializers
from units import models

class UnitsSerializer(serializers.ModelSerializer):
    class Meta:
        model = models.Units
        fields = '__all__'