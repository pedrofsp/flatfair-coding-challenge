from operator import truediv
from rest_framework import viewsets
from rest_framework.response import Response
from rest_framework.decorators import action
from .serializers import UnitsSerializer
from units.api import serializers
from units import models

class UnitsViewSet(viewsets.ModelViewSet):
    serializer_class = serializers.UnitsSerializer
    queryset = models.Units.objects.all()
    http_method_names = ['get', 'post', 'delete']

    def generate_error_message(self, message):
        return {
            'success' : False,
            'message' : 'paramters not found'
        }

    def calculate_membership_fee(self, rent_amount, rent_period, organisation_unit):
        if(rent_period == 'week'):
            if(rent_amount < 25 or rent_amount > 2000):
                self.generate_error_message("Rent amount's outiside the range")
        if(rent_period == 'month'):
            if(rent_amount < 110 or rent_amount > 8660):
                self.generate_error_message("Rent amount's outiside the range")
        if(organisation_unit.get('has_fixed_membership_fee')):
            return organisation_unit.get('fixed_membership_fee_amount')
        calc = int(rent_amount * 0.2)
        if(rent_amount < 120):
            calc = int(120 * 0.2)
        return calc

    def retrieve(self, request, *args, **kwargs):
        param = kwargs.get('pk')
        param = param.split(',')
        id_unit_param = param[0]
        if (param[1] == None or param[2] == None):
            return Response(self.generate_error_message('paramters not found'))
        rent_amount = int(param[1])
        rent_period = param[2]
        unit = models.Units.objects.filter(id_units=id_unit_param)
        serializer = UnitsSerializer(unit, many=True)
        membership_fee = self.calculate_membership_fee(rent_amount, rent_period, serializer.data[0])
        return Response({
            'success' : True,
            'rent amount' : rent_amount,
            'rent period' : rent_period,
            'unit' : serializer.data,
            'membership fee' : membership_fee
        })
