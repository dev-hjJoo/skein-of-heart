from django.urls import path
from SOH_react import views

urlpatterns = [
    path('correcting/', views.correct)
]
